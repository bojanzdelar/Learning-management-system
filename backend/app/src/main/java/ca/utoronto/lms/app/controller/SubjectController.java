package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.SubjectDTO;
import ca.utoronto.lms.app.model.Subject;
import ca.utoronto.lms.app.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController extends BaseController<Subject, SubjectDTO, Long> {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        super(service);
        this.service = service;
    }
}
