package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.FacultyDTO;
import ca.utoronto.lms.app.mapper.FacultyMapper;
import ca.utoronto.lms.app.model.Faculty;
import ca.utoronto.lms.app.repository.FacultyRepository;

@Service
public class FacultyService extends BaseService<Faculty, FacultyDTO, Long> {
    private final FacultyRepository repository;
    private final FacultyMapper mapper;

    public FacultyService(FacultyRepository repository, FacultyMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}