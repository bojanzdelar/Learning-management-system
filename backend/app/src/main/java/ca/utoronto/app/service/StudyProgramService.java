package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.StudyProgramDTO;
import ca.utoronto.app.mapper.StudyProgramMapper;
import ca.utoronto.app.model.StudyProgram;
import ca.utoronto.app.repository.StudyProgramRepository;

@Service
public class StudyProgramService extends BaseService<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramRepository repository;
    private final StudyProgramMapper mapper;

    public StudyProgramService(StudyProgramRepository repository, StudyProgramMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}