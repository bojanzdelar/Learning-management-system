package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.ThesisDTO;
import ca.utoronto.lms.faculty.mapper.ThesisMapper;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.faculty.repository.StudentRepository;
import ca.utoronto.lms.faculty.repository.ThesisRepository;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ThesisService extends BaseService<Thesis, ThesisDTO, Long> {
    private final ThesisRepository repository;
    private final ThesisMapper mapper;
    private final StudentRepository studentRepository;

    public ThesisService(
            ThesisRepository repository, ThesisMapper mapper, StudentRepository studentRepository) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public ThesisDTO save(ThesisDTO thesisDTO) {
        ThesisDTO savedThesisDTO = super.save(thesisDTO);

        Student newStudent =
                studentRepository
                        .findById(thesisDTO.getStudent().getId())
                        .orElseThrow(() -> new NotFoundException("Student not found"));

        if (thesisDTO.getId() != null) {
            Student oldStudent =
                    studentRepository
                            .findByThesisId(thesisDTO.getId())
                            .orElseThrow(() -> new NotFoundException("Student not found"));

            if (!oldStudent.getId().equals(newStudent.getId())) {
                oldStudent.setThesis(null);
                studentRepository.save(oldStudent);
            }
        }

        newStudent.setThesis(mapper.toModel(savedThesisDTO));
        studentRepository.save(newStudent);

        return savedThesisDTO;
    }

    @Override
    @Transactional
    public void delete(Set<Long> ids) {
        List<Thesis> thesis = (List<Thesis>) repository.findAllById(ids);
        thesis.forEach(
                t -> {
                    Student student = t.getStudent();
                    if (student != null) {
                        student.setThesis(null);
                        studentRepository.save(student);
                    }
                });
        repository.softDeleteByIds(ids);
    }

    public ThesisDTO findByStudentId(Long id) {
        Thesis thesis =
                repository
                        .findByStudentId(id)
                        .orElseThrow(() -> new NotFoundException("Thesis not found"));
        return mapper.toDTO(thesis);
    }
}
