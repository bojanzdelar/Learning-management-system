package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.app.mapper.SubjectEnrollmentMapper;
import ca.utoronto.app.model.SubjectEnrollment;
import ca.utoronto.app.repository.SubjectEnrollmentRepository;

@Service
public class SubjectEnrollmentService extends BaseService<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentRepository repository;
    private final SubjectEnrollmentMapper mapper;

    public SubjectEnrollmentService(SubjectEnrollmentRepository repository, SubjectEnrollmentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}