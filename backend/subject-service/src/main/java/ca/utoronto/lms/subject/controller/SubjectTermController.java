package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectTermDTO;
import ca.utoronto.lms.subject.model.SubjectTerm;
import ca.utoronto.lms.subject.service.SubjectTermService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject-service/subject-terms")
public class SubjectTermController extends BaseController<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermService service;

    public SubjectTermController(SubjectTermService service) {
        super(service);
        this.service = service;
    }
}
