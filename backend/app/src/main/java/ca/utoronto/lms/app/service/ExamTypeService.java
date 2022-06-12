package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.ExamTypeDTO;
import ca.utoronto.lms.app.mapper.ExamTypeMapper;
import ca.utoronto.lms.app.model.ExamType;
import ca.utoronto.lms.app.repository.ExamTypeRepository;

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