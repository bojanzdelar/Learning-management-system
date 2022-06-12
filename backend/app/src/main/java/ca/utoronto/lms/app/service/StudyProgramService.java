package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.StudyProgramDTO;
import ca.utoronto.lms.app.mapper.StudyProgramMapper;
import ca.utoronto.lms.app.model.StudyProgram;
import ca.utoronto.lms.app.repository.StudyProgramRepository;

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