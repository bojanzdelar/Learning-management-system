package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.ExamPeriodDTO;
import ca.utoronto.app.mapper.ExamPeriodMapper;
import ca.utoronto.app.model.ExamPeriod;
import ca.utoronto.app.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService extends BaseService<ExamPeriod, ExamPeriodDTO, Long> {
    private final ExamPeriodRepository repository;
    private final ExamPeriodMapper mapper;

    public ExamPeriodService(ExamPeriodRepository repository, ExamPeriodMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
