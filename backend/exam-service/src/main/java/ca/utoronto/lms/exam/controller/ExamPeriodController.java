package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamPeriodDTO;
import ca.utoronto.lms.exam.model.ExamPeriod;
import ca.utoronto.lms.exam.service.ExamPeriodService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-periods")
public class ExamPeriodController extends BaseController<ExamPeriod, ExamPeriodDTO, Long> {
    private final ExamPeriodService service;

    public ExamPeriodController(ExamPeriodService service) {
        super(service);
        this.service = service;
    }
}
