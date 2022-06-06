package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.app.model.SubjectEnrollment;
import ca.utoronto.app.service.SubjectEnrollmentService;

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
