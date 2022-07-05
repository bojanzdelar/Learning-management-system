package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.feign.UserFeignClient;
import ca.utoronto.lms.faculty.mapper.StudentMapper;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.repository.StudentRepository;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends ExtendedService<Student, StudentDTO, Long> {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Autowired private UserFeignClient userFeignClient;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<StudentDTO> mapMissingValues(List<StudentDTO> students) {
        map(
                students,
                StudentDTO::getUser,
                StudentDTO::setUser,
                (ID) -> userFeignClient.getUser(ID));

        return students;
    }
}
