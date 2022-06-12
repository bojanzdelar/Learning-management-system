package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.ExamRealizationDTO;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.mapper.ExamRealizationMapper;
import ca.utoronto.lms.app.model.ExamRealization;
import ca.utoronto.lms.app.repository.ExamRealizationRepository;

@Service
public class ExamRealizationService extends BaseService<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationRepository repository;
    private final ExamRealizationMapper mapper;

    public ExamRealizationService(ExamRealizationRepository repository, ExamRealizationMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}