package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.shared.service.BaseService;
import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.mapper.StudyProgramMapper;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.repository.StudyProgramRepository;
import org.springframework.stereotype.Service;

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
