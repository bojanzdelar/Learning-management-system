package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.StudentDTO;
import ca.utoronto.app.mapper.StudentMapper;
import ca.utoronto.app.model.Student;
import ca.utoronto.app.repository.StudentRepository;

@Service
public class StudentService extends BaseService<Student, StudentDTO, Long> {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}