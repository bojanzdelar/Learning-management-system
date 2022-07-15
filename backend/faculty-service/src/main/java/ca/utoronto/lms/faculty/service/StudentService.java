package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.feign.SubjectFeignClient;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService extends ExtendedService<Student, StudentDTO, Long> {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Autowired private UserFeignClient userFeignClient;
    @Autowired private SubjectFeignClient subjectFeignClient;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<StudentDTO> findById(Set<Long> id) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)
                && (id.size() > 1 || !id.contains(SecurityUtils.getStudentId()))) {
            throw new RuntimeException("Forbidden");
        }

        return super.findById(id);
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
                                                                .id(SecurityUtils.ROLE_STUDENT_ID)
                                                                .authority(
                                                                        SecurityUtils.ROLE_STUDENT)
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

    public StudentDTO findByUserId(Long userId) {
        return mapper.toDTO(repository.findByUserId(userId));
    }

    public List<StudentDTO> findBySubjectId(Long id) {
        Set<Long> studentIds = new HashSet<>(subjectFeignClient.getStudentIdsBySubjectId(id));
        List<StudentDTO> students = mapper.toDTO(repository.findByIdInAndDeletedFalse(studentIds));
        return students.isEmpty() ? students : mapMissingValues(students);
    }

    public Page<StudentDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        Set<Long> studentIds = new HashSet<>(subjectFeignClient.getStudentIdsBySubjectId(id));
        Page<StudentDTO> students =
                repository
                        .findByIdContaining(studentIds, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return students.getContent().isEmpty()
                ? students
                : new PageImpl<>(
                        this.mapMissingValues(students.getContent()),
                        pageable,
                        students.getTotalElements());
    }
}
