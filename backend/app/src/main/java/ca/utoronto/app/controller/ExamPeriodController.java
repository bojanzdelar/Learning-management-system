package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.ExamPeriodDTO;
import ca.utoronto.app.model.ExamPeriod;
import ca.utoronto.app.service.ExamPeriodService;

@RestController
@RequestMapping("/api/exam-period")
public class ExamPeriodController extends BaseController<ExamPeriod, ExamPeriodDTO, Long> {
    private final ExamPeriodService service;

    public ExamPeriodController(ExamPeriodService service) {
        super(service);
        this.service = service;
    }
}
