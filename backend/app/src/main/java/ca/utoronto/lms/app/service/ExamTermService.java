package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.ExamTermDTO;
import ca.utoronto.lms.app.repository.ExamTermRepository;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.mapper.ExamTermMapper;
import ca.utoronto.lms.app.model.ExamTerm;

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
