package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.ExamDTO;
import ca.utoronto.app.mapper.ExamMapper;
import ca.utoronto.app.model.Exam;
import ca.utoronto.app.repository.ExamRepository;

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