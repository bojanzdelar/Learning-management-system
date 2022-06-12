package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.ExamDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.model.Exam;
import ca.utoronto.lms.app.service.ExamService;

@RestController
@RequestMapping("/api/exam")
public class ExamController extends BaseController<Exam, ExamDTO, Long> {
    private final ExamService service;

    public ExamController(ExamService service) {
        super(service);
        this.service = service;
    }
}
