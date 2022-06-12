package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.SubjectTermDTO;
import ca.utoronto.lms.app.model.SubjectTerm;
import ca.utoronto.lms.app.service.SubjectTermService;

@RestController
@RequestMapping("/api/subject-term")
public class SubjectTermController extends BaseController<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermService service;

    public SubjectTermController(SubjectTermService service) {
        super(service);
        this.service = service;
    }
}
