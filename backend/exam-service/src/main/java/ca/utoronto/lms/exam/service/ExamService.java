package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.client.SubjectFeignClient;
import ca.utoronto.lms.exam.dto.ExamDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.mapper.ExamMapper;
import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.exam.repository.ExamRepository;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class ExamService extends ExtendedService<Exam, ExamDTO, Long> {
    private final ExamRepository repository;
    private final ExamMapper mapper;
    private final SubjectFeignClient subjectFeignClient;

    public ExamService(
            ExamRepository repository, ExamMapper mapper, SubjectFeignClient subjectFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.subjectFeignClient = subjectFeignClient;
    }

    @Override
    @Transactional
    public ExamDTO save(ExamDTO examDTO) {
        if (hasAuthority(ROLE_TEACHER)) {
            Long teacherId = getTeacherId();
            SubjectDTO subject = examDTO.getSubject();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new ForbiddenException(
                        "You are not allowed to add materials to this subject");
            }
        }

        return super.save(examDTO);
    }

    @Override
    @Transactional
    public void delete(Set<Long> id) {
        if (hasAuthority(ROLE_TEACHER)) {
            Long teacherId = getTeacherId();
            List<Exam> exams = (List<Exam>) repository.findAllById(id);
            List<SubjectDTO> subjects =
                    subjectFeignClient.getSubject(
                            exams.stream().map(Exam::getSubjectId).collect(Collectors.toSet()));

            boolean forbidden =
                    subjects.stream()
                            .anyMatch(
                                    subject ->
                                            !subject.getProfessor().getId().equals(teacherId)
                                                    && !subject.getAssistant()
                                                            .getId()
                                                            .equals(teacherId));
            if (forbidden) {
                throw new ForbiddenException("You are not allowed to delete these exams");
            }
        }

        super.delete(id);
    }

    @Override
    protected List<ExamDTO> mapMissingValues(List<ExamDTO> exams) {
        map(exams, ExamDTO::getSubject, ExamDTO::setSubject, subjectFeignClient::getSubject);
        return exams;
    }

    public List<ExamDTO> findBySubjectId(Long id) {
        List<ExamDTO> exams = mapper.toDTO(repository.findBySubjectIdAndDeletedFalse(id));
        return exams.isEmpty() ? exams : this.mapMissingValues(exams);
    }

    public Page<ExamDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        Page<ExamDTO> exams =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return exams.getContent().isEmpty()
                ? exams
                : new PageImpl<>(
                        this.mapMissingValues(exams.getContent()),
                        pageable,
                        exams.getTotalElements());
    }
}
