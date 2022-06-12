package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.ExamTermDTO;
import ca.utoronto.lms.app.service.ExamTermService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.model.ExamTerm;

@RestController
@RequestMapping("/api/exam-term")
public class ExamTermController extends BaseController<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermService service;

    public ExamTermController(ExamTermService service) {
        super(service);
        this.service = service;
    }
}
