package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.TeacherDTO;
import ca.utoronto.lms.app.mapper.TeacherMapper;
import ca.utoronto.lms.app.model.Teacher;
import ca.utoronto.lms.app.repository.TeacherRepository;

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