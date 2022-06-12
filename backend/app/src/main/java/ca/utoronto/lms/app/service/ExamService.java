package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.ExamDTO;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.mapper.ExamMapper;
import ca.utoronto.lms.app.model.Exam;
import ca.utoronto.lms.app.repository.ExamRepository;

@Service
public class ExamService extends BaseService<Exam, ExamDTO, Long> {
    private final ExamRepository repository;
    private final ExamMapper mapper;

    public ExamService(ExamRepository repository, ExamMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}