package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.exam.client.SubjectFeignClient;
import ca.utoronto.lms.exam.mapper.ExamTermMapper;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.repository.ExamRealizationRepository;
import ca.utoronto.lms.exam.repository.ExamTermRepository;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class ExamTermService extends ExtendedService<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermRepository repository;
    private final ExamTermMapper mapper;
    private final ExamRealizationRepository examRealizationRepository;
    private final SubjectFeignClient subjectFeignClient;

    public ExamTermService(
            ExamTermRepository repository,
            ExamTermMapper mapper,
            ExamRealizationRepository examRealizationRepository,
            SubjectFeignClient subjectFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.examRealizationRepository = examRealizationRepository;
        this.subjectFeignClient = subjectFeignClient;
    }

    @Override
    protected List<ExamTermDTO> mapMissingValues(List<ExamTermDTO> examTerms) {
        map(
                examTerms,
                examTerm -> examTerm.getExam().getSubject(),
                (examTerm, subject) -> examTerm.getExam().setSubject(subject),
                subjectFeignClient::getSubject);

        return examTerms;
    }

    public List<ExamTermDTO> findBySubjectId(Long id) {
        List<ExamTermDTO> examTerms =
                mapper.toDTO(repository.findByExamSubjectIdAndDeletedFalseOrderByStartTimeDesc(id));
        return examTerms.isEmpty() ? examTerms : this.mapMissingValues(examTerms);
    }

    public List<ExamTermDTO> findByTeacherId(Long id) {
        List<Long> subjectIds =
                subjectFeignClient.getSubjectByTeacherId(id).stream()
                        .map(SubjectDTO::getId)
                        .toList();

        List<ExamTermDTO> examTerms =
                mapper.toDTO(
                        repository.findByExamSubjectIdInAndDeletedFalseOrderByStartTimeDesc(
                                subjectIds));
        return examTerms.isEmpty() ? examTerms : this.mapMissingValues(examTerms);
    }

    public Page<ExamTermDTO> findByStudentId(Long id, Pageable pageable, String search) {
        if (hasAuthority(ROLE_STUDENT) && !id.equals(getStudentId())) {
            throw new ForbiddenException("You are not allowed to view these exam terms");
        }

        List<Long> subjectIds =
                subjectFeignClient.getSubjectByStudentId(id).stream()
                        .map(SubjectDTO::getId)
                        .toList();

        List<Long> subjectEnrollmentIds =
                subjectFeignClient.getSubjectEnrollmentByStudentId(id).stream()
                        .map(SubjectEnrollmentDTO::getId)
                        .toList();

        List<Long> examRealizationIds =
                examRealizationRepository
                        .findBySubjectEnrollmentIdInAndDeletedFalse(subjectEnrollmentIds)
                        .stream()
                        .map(ExamRealization::getId)
                        .toList();

        List<Long> registeredExamTermIds =
                repository
                        .findByExamSubjectIdInAndExamRealizationsIdInAndDeletedFalse(
                                subjectIds, examRealizationIds)
                        .stream()
                        .map(ExamTerm::getId)
                        .toList();

        Page<ExamTermDTO> examTerms =
                repository
                        .findRegistrableContaining(
                                subjectIds,
                                registeredExamTermIds,
                                LocalDate.now(),
                                pageable,
                                "%" + search + "%")
                        .map(mapper::toDTO);

        return examTerms.isEmpty()
                ? examTerms
                : new PageImpl<>(
                        this.mapMissingValues(examTerms.getContent()),
                        pageable,
                        examTerms.getTotalElements());
    }
}
