package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.ExamPeriodDTO;
import ca.utoronto.lms.app.service.ExamPeriodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.model.ExamPeriod;

@RestController
@RequestMapping("/api/exam-period")
public class ExamPeriodController extends BaseController<ExamPeriod, ExamPeriodDTO, Long> {
    private final ExamPeriodService service;

    public ExamPeriodController(ExamPeriodService service) {
        super(service);
        this.service = service;
    }
}
