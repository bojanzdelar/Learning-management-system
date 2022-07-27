package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.mapper.StudyProgramMapper;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.repository.FacultyRepository;
import ca.utoronto.lms.faculty.repository.StudyProgramRepository;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramService extends BaseService<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramRepository repository;
    private final StudyProgramMapper mapper;
    private final FacultyRepository facultyRepository;

    public StudyProgramService(
            StudyProgramRepository repository,
            StudyProgramMapper mapper,
            FacultyRepository facultyRepository) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.facultyRepository = facultyRepository;
    }

    public List<StudyProgramDTO> findByFacultyId(Long id) {
        if (!facultyRepository.existsById(id)) {
            throw new NotFoundException("Faculty not found");
        }
        return mapper.toDTO(repository.findByFacultyIdAndDeletedFalse(id));
    }
}
