package ca.utoronto.lms.faculty.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.mapper.StudyProgramMapper;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.repository.StudyProgramRepository;

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
