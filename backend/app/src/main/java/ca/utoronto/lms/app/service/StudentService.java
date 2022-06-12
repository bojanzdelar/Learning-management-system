package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.StudentDTO;
import ca.utoronto.lms.app.repository.StudentRepository;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.mapper.StudentMapper;
import ca.utoronto.lms.app.model.Student;

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