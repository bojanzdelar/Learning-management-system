package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.shared.service.BaseService;
import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.mapper.StudentMapper;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.repository.StudentRepository;
import org.springframework.stereotype.Service;

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
