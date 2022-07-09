package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.feign.UserFeignClient;
import ca.utoronto.lms.faculty.mapper.TeacherMapper;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.faculty.repository.TeacherRepository;
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
public class TeacherService extends ExtendedService<Teacher, TeacherDTO, Long> {
    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    @Autowired private UserFeignClient userFeignClient;

    public TeacherService(TeacherRepository repository, TeacherMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TeacherDTO save(TeacherDTO teacher) {
        UserDTO userRequest = teacher.getUser();
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
        teacher.setUser(userResponse);
        return super.save(teacher);
    }

    @Override
    public void delete(Set<Long> id) {
        List<Teacher> teachers = (List<Teacher>) repository.findAllById(id);
        Set<Long> userIds = teachers.stream().map(Teacher::getUserId).collect(Collectors.toSet());
        userFeignClient.deleteUser(userIds);
        repository.softDeleteByIds(id);
    }

    @Override
    protected List<TeacherDTO> mapMissingValues(List<TeacherDTO> teachers) {
        map(
                teachers,
                TeacherDTO::getUser,
                TeacherDTO::setUser,
                (ID) -> userFeignClient.getUser(ID));

        return teachers;
    }
}
