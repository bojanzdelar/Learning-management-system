package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.shared.service.BaseService;
import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.mapper.TeacherMapper;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.faculty.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends BaseService<Teacher, TeacherDTO, Long> {
    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    public TeacherService(TeacherRepository repository, TeacherMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
