package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.app.mapper.SubjectEnrollmentMapper;
import ca.utoronto.lms.app.model.SubjectEnrollment;
import ca.utoronto.lms.app.repository.SubjectEnrollmentRepository;

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