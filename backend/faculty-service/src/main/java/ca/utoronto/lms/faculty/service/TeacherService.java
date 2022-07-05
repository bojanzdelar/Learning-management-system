package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.feign.UserFeignClient;
import ca.utoronto.lms.faculty.mapper.TeacherMapper;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.faculty.repository.TeacherRepository;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    protected List<TeacherDTO> mapMissingValues(List<TeacherDTO> teachers) {
        map(
                teachers,
                TeacherDTO::getUser,
                TeacherDTO::setUser,
                (ID) -> userFeignClient.getUser(ID));

        return teachers;
    }
}
