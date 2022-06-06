package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.ExamDTO;
import ca.utoronto.app.model.Exam;
import ca.utoronto.app.service.ExamService;

@RestController
@RequestMapping("/api/exam")
public class ExamController extends BaseController<Exam, ExamDTO, Long> {
    private final ExamService service;

    public ExamController(ExamService service) {
        super(service);
        this.service = service;
    }
}
