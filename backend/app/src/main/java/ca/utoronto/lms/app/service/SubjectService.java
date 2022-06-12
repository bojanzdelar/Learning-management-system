package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.SubjectDTO;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.mapper.SubjectMapper;
import ca.utoronto.lms.app.model.Subject;
import ca.utoronto.lms.app.repository.SubjectRepository;

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