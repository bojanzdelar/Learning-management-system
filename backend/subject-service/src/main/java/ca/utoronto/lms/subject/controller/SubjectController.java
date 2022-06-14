package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.service.SubjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject-service/subjects")
public class SubjectController extends BaseController<Subject, SubjectDTO, Long> {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        super(service);
        this.service = service;
    }
}
