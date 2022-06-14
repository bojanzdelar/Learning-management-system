package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamDTO;
import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.exam.service.ExamService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam-service/exams")
public class ExamController extends BaseController<Exam, ExamDTO, Long> {
    private final ExamService service;

    public ExamController(ExamService service) {
        super(service);
        this.service = service;
    }
}
