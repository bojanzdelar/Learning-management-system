package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.SubjectDTO;
import ca.utoronto.app.mapper.SubjectMapper;
import ca.utoronto.app.model.Subject;
import ca.utoronto.app.repository.SubjectRepository;

@Service
public class SubjectService extends BaseService<Subject, SubjectDTO, Long> {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    public SubjectService(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}