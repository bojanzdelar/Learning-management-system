package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.TeacherDTO;
import ca.utoronto.app.mapper.TeacherMapper;
import ca.utoronto.app.model.Teacher;
import ca.utoronto.app.repository.TeacherRepository;

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