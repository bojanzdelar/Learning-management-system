package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.ExamRealizationDTO;
import ca.utoronto.app.mapper.ExamRealizationMapper;
import ca.utoronto.app.model.ExamRealization;
import ca.utoronto.app.repository.ExamRealizationRepository;

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