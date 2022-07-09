package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.feign.UserFeignClient;
import ca.utoronto.lms.faculty.mapper.StudentMapper;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.repository.StudentRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public StudentDTO save(StudentDTO student) {
        UserDTO userRequest = student.getUser();
        UserDTO userResponse =
                userRequest.getId() == null
                        ? userFeignClient.createUser(
                                UserDetailsDTO.builder()
                                        .username(userRequest.getUsername())
                                        .password(userRequest.getPassword())
                                        .authorities(
                                                Set.of(
                                                        RoleDTO.builder()
                                                                .id(SecurityUtils.ROLE_ADMIN_ID)
                                                                .authority(SecurityUtils.ROLE_ADMIN)
                                                                .build()))
                                        .build())
                        : userFeignClient.patchUser(userRequest.getId(), userRequest);
        student.setUser(userResponse);
        return super.save(student);
    }

    @Override
    public void delete(Set<Long> id) {
        List<Student> students = (List<Student>) repository.findAllById(id);
        Set<Long> userIds = students.stream().map(Student::getUserId).collect(Collectors.toSet());
        userFeignClient.deleteUser(userIds);
        repository.softDeleteByIds(id);
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
