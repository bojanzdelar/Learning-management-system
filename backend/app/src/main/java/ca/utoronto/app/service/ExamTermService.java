package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.ExamTermDTO;
import ca.utoronto.app.mapper.ExamTermMapper;
import ca.utoronto.app.model.ExamTerm;
import ca.utoronto.app.repository.ExamTermRepository;

@Service
public class ExamTermService extends BaseService<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermRepository repository;
    private final ExamTermMapper mapper;

    public ExamTermService(ExamTermRepository repository, ExamTermMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
