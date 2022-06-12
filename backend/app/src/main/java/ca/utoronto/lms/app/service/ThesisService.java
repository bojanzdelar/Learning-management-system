package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.ThesisDTO;
import ca.utoronto.lms.app.mapper.ThesisMapper;
import ca.utoronto.lms.app.model.Thesis;
import ca.utoronto.lms.app.repository.ThesisRepository;

@Service
public class ThesisService extends BaseService<Thesis, ThesisDTO, Long> {
    private final ThesisRepository repository;
    private final ThesisMapper mapper;

    public ThesisService(ThesisRepository repository, ThesisMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}