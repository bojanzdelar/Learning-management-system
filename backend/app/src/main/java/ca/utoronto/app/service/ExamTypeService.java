package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.ExamTypeDTO;
import ca.utoronto.app.mapper.ExamTypeMapper;
import ca.utoronto.app.model.ExamType;
import ca.utoronto.app.repository.ExamTypeRepository;

@Service
public class ExamTypeService extends BaseService<ExamType, ExamTypeDTO, Long> {
    private final ExamTypeRepository repository;
    private final ExamTypeMapper mapper;

    public ExamTypeService(ExamTypeRepository repository, ExamTypeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}