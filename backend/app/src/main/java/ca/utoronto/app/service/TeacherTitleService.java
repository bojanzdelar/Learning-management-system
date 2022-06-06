package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.TeacherTitleDTO;
import ca.utoronto.app.mapper.TeacherTitleMapper;
import ca.utoronto.app.model.TeacherTitle;
import ca.utoronto.app.repository.TeacherTitleRepository;

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
