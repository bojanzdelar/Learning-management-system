package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.shared.service.BaseService;
import ca.utoronto.lms.faculty.dto.ThesisDTO;
import ca.utoronto.lms.faculty.mapper.ThesisMapper;
import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.faculty.repository.ThesisRepository;
import org.springframework.stereotype.Service;

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
