package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.feign.SubjectFeignClient;
import ca.utoronto.lms.exam.mapper.ExamTermMapper;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.repository.ExamTermRepository;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamTermService extends ExtendedService<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermRepository repository;
    private final ExamTermMapper mapper;

    @Autowired private SubjectFeignClient subjectFeignClient;

    public ExamTermService(ExamTermRepository repository, ExamTermMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<ExamTermDTO> mapMissingValues(List<ExamTermDTO> examTerms) {
        map(
                examTerms,
                examTerm -> examTerm.getExam().getSubject(),
                (examTerm, subject) -> examTerm.getExam().setSubject(subject),
                (ID) -> subjectFeignClient.getSubject(ID));

        return examTerms;
    }

    public List<ExamTermDTO> findBySubjectId(Long id) {
        List<ExamTermDTO> examTerms =
                mapper.toDTO(repository.findByExamSubjectIdAndDeletedFalseOrderByStartTimeDesc(id));
        return examTerms.isEmpty() ? examTerms : this.mapMissingValues(examTerms);
    }

    public List<ExamTermDTO> findByTeacherUsername(String username) {
        List<Long> subjectIds =
                subjectFeignClient.getSubjectByTeacherUsername(username).stream()
                        .map(SubjectDTO::getId)
                        .toList();

        List<ExamTermDTO> examTerms =
                mapper.toDTO(
                        repository.findByExamSubjectIdInAndDeletedFalseOrderByStartTimeDesc(
                                subjectIds));
        return examTerms.isEmpty() ? examTerms : this.mapMissingValues(examTerms);
    }
}
