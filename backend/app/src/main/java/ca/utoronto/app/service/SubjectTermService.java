package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.SubjectTermDTO;
import ca.utoronto.app.mapper.SubjectTermMapper;
import ca.utoronto.app.model.SubjectTerm;
import ca.utoronto.app.repository.SubjectTermRepository;

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
