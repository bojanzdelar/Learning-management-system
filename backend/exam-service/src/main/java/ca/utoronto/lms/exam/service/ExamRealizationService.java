package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.client.SubjectFeignClient;
import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.exam.mapper.ExamRealizationMapper;
import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.repository.ExamRealizationRepository;
import ca.utoronto.lms.exam.repository.ExamTermRepository;
import ca.utoronto.lms.shared.exception.BadRequestException;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class ExamRealizationService
        extends ExtendedService<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationRepository repository;
    private final ExamRealizationMapper mapper;
    private final ExamTermService examTermService;
    private final ExamTermRepository examTermRepository;
    private final SubjectFeignClient subjectFeignClient;

    public ExamRealizationService(
            ExamRealizationRepository repository,
            ExamRealizationMapper mapper,
            ExamTermService examTermService,
            ExamTermRepository examTermRepository,
            SubjectFeignClient subjectFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.examTermService = examTermService;
        this.examTermRepository = examTermRepository;
        this.subjectFeignClient = subjectFeignClient;
    }

    @Override
    protected List<ExamRealizationDTO> mapMissingValues(List<ExamRealizationDTO> examRealizations) {
        map(
                examRealizations,
                ExamRealizationDTO::getSubjectEnrollment,
                ExamRealizationDTO::setSubjectEnrollment,
                subjectFeignClient::getSubjectEnrollment);

        return examRealizations;
    }

    public List<ExamRealizationDTO> findByExamTermId(Long id) {
        if (!examTermRepository.existsById(id)) {
            throw new NotFoundException("Exam term id not found");
        }

        if (hasAuthority(ROLE_TEACHER)) {
            ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = getTeacherId();
            if (!teacherId.equals(subject.getProfessor().getId())
                    && !teacherId.equals(subject.getAssistant().getId())) {
                throw new ForbiddenException("You are not allowed to view this exam realization");
            }
        }

        List<ExamRealizationDTO> examRealizations =
                mapper.toDTO(repository.findByExamTermIdAndDeletedFalse(id));
        return examRealizations.isEmpty() ? examRealizations : mapMissingValues(examRealizations);
    }

    public Page<ExamRealizationDTO> findByExamTermId(Long id, Pageable pageable, String search) {
        if (!examTermRepository.existsById(id)) {
            throw new NotFoundException("Exam term id not found");
        }

        if (hasAuthority(ROLE_TEACHER)) {
            ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = getTeacherId();
            if (!teacherId.equals(subject.getProfessor().getId())
                    && !teacherId.equals(subject.getAssistant().getId())) {
                throw new ForbiddenException("You are not allowed to view this exam realizations");
            }
        }

        Page<ExamRealizationDTO> examRealizations =
                repository
                        .findByExamTermIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return examRealizations.getContent().isEmpty()
                ? examRealizations
                : new PageImpl<>(
                        this.mapMissingValues(examRealizations.getContent()),
                        pageable,
                        examRealizations.getTotalElements());
    }

    public Page<ExamRealizationDTO> findByStudentId(Long id, Pageable pageable, String search) {
        if (hasAuthority(ROLE_STUDENT) && !id.equals(getStudentId())) {
            throw new ForbiddenException("You are not allowed to view these exam realizations.");
        }

        List<Long> subjectEnrollmentIds =
                subjectFeignClient.getSubjectEnrollmentByStudentId(id).stream()
                        .map(SubjectEnrollmentDTO::getId)
                        .toList();

        Page<ExamRealizationDTO> examRealizations =
                repository
                        .findBySubjectEnrollmentIdsContaining(
                                subjectEnrollmentIds, pageable, "%" + search + "%")
                        .map(mapper::toDTO);

        return examRealizations.getContent().isEmpty()
                ? examRealizations
                : new PageImpl<>(
                        this.mapMissingValues(examRealizations.getContent()),
                        pageable,
                        examRealizations.getTotalElements());
    }

    @Transactional
    public List<ExamRealizationDTO> createByExamTermId(Set<Long> examTermIds) {
        boolean notExists =
                examTermIds.stream()
                        .anyMatch(examTermId -> !examTermRepository.existsById(examTermId));
        if (notExists) {
            throw new BadRequestException("Exam term id does not exist");
        }

        if (!hasAuthority(ROLE_STUDENT)) {
            throw new ForbiddenException(
                    "You are not allowed to create exam realizations for this exam term");
        }

        List<ExamTerm> examTerms = (List<ExamTerm>) examTermRepository.findAllById(examTermIds);
        List<Long> subjectIds =
                examTerms.stream().map(ExamTerm::getExam).map(Exam::getSubjectId).toList();
        List<SubjectEnrollmentDTO> subjectEnrollments =
                subjectFeignClient.getSubjectEnrollmentByStudentId(getStudentId());

        List<ExamRealization> examRealizations = new ArrayList<>();
        for (int i = 0; i < examTerms.size(); i++) {
            ExamTerm examTerm = examTerms.get(i);
            Long subjectId = subjectIds.get(i);
            Long subjectEnrollmentId =
                    subjectEnrollments.stream()
                            .filter(se -> se.getSubject().getId().equals(subjectId))
                            .map(SubjectEnrollmentDTO::getId)
                            .findFirst()
                            .orElse(null);
            examRealizations.add(new ExamRealization(subjectEnrollmentId, examTerm, null));
        }

        return mapper.toDTO((List<ExamRealization>) repository.saveAll(examRealizations));
    }

    @Transactional
    public ExamRealizationDTO updateScore(Long id, ExamRealizationDTO examRealizationDTO) {
        ExamRealizationDTO examRealization = findById(Set.of(id)).get(0);

        if (hasAuthority(ROLE_TEACHER)) {
            SubjectDTO subject = examRealization.getSubjectEnrollment().getSubject();
            Long teacherId = getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new ForbiddenException(
                        "You are not allowed to update score for this exam realization");
            }
        }

        examRealization.setScore(examRealizationDTO.getScore());
        ExamRealization updatedExamRealization = repository.save(mapper.toModel(examRealization));
        return mapper.toDTO(updatedExamRealization);
    }

    @Transactional
    public List<ExamRealizationDTO> updateScoresByExamTermId(
            Long id, List<ExamRealizationDTO> examRealizationsDTO) {
        ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);

        if (hasAuthority(ROLE_TEACHER)) {
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new ForbiddenException(
                        "You are not allowed to update scores for this exam term");
            }
        }

        List<ExamRealization> examRealizations =
                (List<ExamRealization>)
                        repository.findAllById(
                                examRealizationsDTO.stream()
                                        .map(ExamRealizationDTO::getId)
                                        .toList());

        if (examRealizations.stream().anyMatch(er -> !er.getExamTerm().getId().equals(id))) {
            throw new BadRequestException("Some of exam realizations are not in this exam term");
        }

        for (int i = 0; i < examRealizations.size(); i++) {
            examRealizations.get(i).setScore(examRealizationsDTO.get(i).getScore());
        }

        return mapper.toDTO((List<ExamRealization>) repository.saveAll(examRealizations));
    }
}
