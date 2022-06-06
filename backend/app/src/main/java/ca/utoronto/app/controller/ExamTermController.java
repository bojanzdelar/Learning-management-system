package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.ExamTermDTO;
import ca.utoronto.app.model.ExamTerm;
import ca.utoronto.app.service.ExamTermService;

@RestController
@RequestMapping("/api/exam-term")
public class ExamTermController extends BaseController<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermService service;

    public ExamTermController(ExamTermService service) {
        super(service);
        this.service = service;
    }
}
