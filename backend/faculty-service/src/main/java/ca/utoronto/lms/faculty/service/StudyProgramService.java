package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.mapper.StudyProgramMapper;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.repository.StudyProgramRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramService extends BaseService<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramRepository repository;
    private final StudyProgramMapper mapper;

    public StudyProgramService(StudyProgramRepository repository, StudyProgramMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<StudyProgramDTO> findByFacultyId(Long id) {
        return mapper.toDTO(repository.findByFacultyId(id));
    }
}
