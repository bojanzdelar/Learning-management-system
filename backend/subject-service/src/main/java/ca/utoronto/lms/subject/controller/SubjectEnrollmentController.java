package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.subject.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import ca.utoronto.lms.subject.service.SubjectEnrollmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject-service/subject-enrollments")
public class SubjectEnrollmentController
        extends BaseController<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentService service;

    public SubjectEnrollmentController(SubjectEnrollmentService service) {
        super(service);
        this.service = service;
    }
}
