package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.service.ExamTermService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam-service/exam-terms")
public class ExamTermController extends BaseController<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermService service;

    public ExamTermController(ExamTermService service) {
        super(service);
        this.service = service;
    }
}
