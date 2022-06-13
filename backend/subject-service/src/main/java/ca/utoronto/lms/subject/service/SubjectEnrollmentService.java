package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.subject.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectEnrollmentMapper;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import ca.utoronto.lms.subject.repository.SubjectEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectEnrollmentService
        extends ExtendedService<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentRepository repository;
    private final SubjectEnrollmentMapper mapper;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectEnrollmentService(
            SubjectEnrollmentRepository repository, SubjectEnrollmentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<SubjectEnrollmentDTO> mapMissingValues(
            List<SubjectEnrollmentDTO> subjectEnrollments) {
        map(
                subjectEnrollments,
                (subjectEnrollment) -> subjectEnrollment.getStudent(),
                (subjectEnrollment, student) -> subjectEnrollment.setStudent(student),
                (ID) -> facultyFeignClient.getStudent(ID));

        return subjectEnrollments;
    }
}
