package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.SubjectTermDTO;
import ca.utoronto.lms.app.mapper.SubjectTermMapper;
import ca.utoronto.lms.app.model.SubjectTerm;
import ca.utoronto.lms.app.repository.SubjectTermRepository;

@Service
public class SubjectTermService extends BaseService<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermRepository repository;
    private final SubjectTermMapper mapper;

    public SubjectTermService(SubjectTermRepository repository, SubjectTermMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
