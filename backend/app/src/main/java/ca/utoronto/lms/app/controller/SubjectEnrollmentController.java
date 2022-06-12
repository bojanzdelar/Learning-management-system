package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.app.model.SubjectEnrollment;
import ca.utoronto.lms.app.service.SubjectEnrollmentService;

@RestController
@RequestMapping("/api/subject-enrollment")
public class SubjectEnrollmentController
        extends BaseController<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentService service;

    public SubjectEnrollmentController(SubjectEnrollmentService service) {
        super(service);
        this.service = service;
    }
}
