package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.ThesisDTO;
import ca.utoronto.app.mapper.ThesisMapper;
import ca.utoronto.app.model.Thesis;
import ca.utoronto.app.repository.ThesisRepository;

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