package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.FacultyDTO;
import ca.utoronto.lms.faculty.mapper.FacultyMapper;
import ca.utoronto.lms.faculty.model.Faculty;
import ca.utoronto.lms.faculty.repository.FacultyRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

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
