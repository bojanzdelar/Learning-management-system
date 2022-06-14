package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.mapper.ExamTermMapper;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.repository.ExamTermRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

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
