package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamDTO;
import ca.utoronto.lms.exam.feign.SubjectFeignClient;
import ca.utoronto.lms.exam.mapper.ExamMapper;
import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.exam.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService extends ExtendedService<Exam, ExamDTO, Long> {
    private final ExamRepository repository;
    private final ExamMapper mapper;

    @Autowired private SubjectFeignClient subjectFeignClient;

    public ExamService(ExamRepository repository, ExamMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<ExamDTO> mapMissingValues(List<ExamDTO> exams) {
        map(
                exams,
                (exam) -> exam.getSubject(),
                (exam, subject) -> exam.setSubject(subject),
                (ID) -> subjectFeignClient.getSubject(ID));

        return exams;
    }
}
