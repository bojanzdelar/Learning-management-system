package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.exam.feign.SubjectFeignClient;
import ca.utoronto.lms.exam.mapper.ExamRealizationMapper;
import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.repository.ExamRealizationRepository;
import ca.utoronto.lms.exam.repository.ExamTermRepository;
import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ExamRealizationService
        extends ExtendedService<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationRepository repository;
    private final ExamRealizationMapper mapper;

    @Autowired private ExamTermService examTermService;
    @Autowired private ExamTermRepository examTermRepository;

    @Autowired private SubjectFeignClient subjectFeignClient;

    public ExamRealizationService(
            ExamRealizationRepository repository, ExamRealizationMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<ExamRealizationDTO> mapMissingValues(List<ExamRealizationDTO> examRealizations) {
        map(
                examRealizations,
                ExamRealizationDTO::getSubjectEnrollment,
                ExamRealizationDTO::setSubjectEnrollment,
                (ID) -> subjectFeignClient.getSubjectEnrollment(ID));

        return examRealizations;
    }

    public List<ExamRealizationDTO> findByExamTermId(Long id) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
            ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = SecurityUtils.getTeacherId();
            if (!teacherId.equals(subject.getProfessor().getId())
                    && !teacherId.equals(subject.getAssistant().getId())) {
                throw new RuntimeException("Forbidden");
            }
        }

        List<ExamRealizationDTO> examRealizations =
                mapper.toDTO(repository.findByExamTermIdAndDeletedFalse(id));
        return examRealizations.isEmpty() ? examRealizations : mapMissingValues(examRealizations);
    }

    public Page<ExamRealizationDTO> findByExamTermId(Long id, Pageable pageable, String search) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
            ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = SecurityUtils.getTeacherId();
            if (!teacherId.equals(subject.getProfessor().getId())
                    && !teacherId.equals(subject.getAssistant().getId())) {
                throw new RuntimeException("Forbidden");
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
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)
                && !id.equals(SecurityUtils.getStudentId())) {
            throw new RuntimeException("You are not authorized to view these exam realizations.");
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

    public List<ExamRealizationDTO> createByExamTermId(Set<Long> id) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)) {
            throw new RuntimeException("Forbidden");
        }

        List<ExamTerm> examTerms = (List<ExamTerm>) examTermRepository.findAllById(id);
        List<Long> subjectIds =
                examTerms.stream().map(ExamTerm::getExam).map(Exam::getSubjectId).toList();
        List<SubjectEnrollmentDTO> subjectEnrollments =
                subjectFeignClient.getSubjectEnrollmentByStudentId(SecurityUtils.getStudentId());

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

    public ExamRealizationDTO updateScore(Long id, ExamRealizationDTO examRealizationDTO) {
        ExamRealizationDTO examRealization = findById(Set.of(id)).get(0);

        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
            SubjectDTO subject = examRealization.getSubjectEnrollment().getSubject();
            Long teacherId = SecurityUtils.getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new RuntimeException("Forbidden");
            }
        }

        examRealization.setScore(examRealizationDTO.getScore());
        ExamRealization updatedExamRealization = repository.save(mapper.toModel(examRealization));
        return mapper.toDTO(updatedExamRealization);
    }

    public List<ExamRealizationDTO> updateScoresByExamTermId(
            Long id, List<ExamRealizationDTO> examRealizationsDTO) {
        ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);

        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = SecurityUtils.getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new RuntimeException("Forbidden");
            }
        }

        List<ExamRealization> examRealizations =
                (List<ExamRealization>)
                        repository.findAllById(
                                examRealizationsDTO.stream()
                                        .map(ExamRealizationDTO::getId)
                                        .toList());

        if (examRealizations.stream().anyMatch(er -> !er.getExamTerm().getId().equals(id))) {
            throw new RuntimeException("Bad request");
        }

        for (int i = 0; i < examRealizations.size(); i++) {
            examRealizations.get(i).setScore(examRealizationsDTO.get(i).getScore());
        }

        return mapper.toDTO((List<ExamRealization>) repository.saveAll(examRealizations));
    }
}
