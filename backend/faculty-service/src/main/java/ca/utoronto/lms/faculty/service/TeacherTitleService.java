package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.TeacherTitleDTO;
import ca.utoronto.lms.faculty.model.TeacherTitle;
import ca.utoronto.lms.faculty.repository.TeacherTitleRepository;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.faculty.mapper.TeacherTitleMapper;

@Service
public class TeacherTitleService extends BaseService<TeacherTitle, TeacherTitleDTO, Long> {
    private final TeacherTitleRepository repository;
    private final TeacherTitleMapper mapper;

    public TeacherTitleService(TeacherTitleRepository repository, TeacherTitleMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
