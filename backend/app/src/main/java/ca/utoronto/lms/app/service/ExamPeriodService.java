package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.ExamPeriodDTO;
import ca.utoronto.lms.app.mapper.ExamPeriodMapper;
import ca.utoronto.lms.app.model.ExamPeriod;
import ca.utoronto.lms.app.repository.ExamPeriodRepository;

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
