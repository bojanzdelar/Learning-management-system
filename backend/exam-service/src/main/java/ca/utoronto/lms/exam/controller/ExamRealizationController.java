package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.service.ExamRealizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam-service/exam-realizations")
public class ExamRealizationController
        extends BaseController<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationService service;

    public ExamRealizationController(ExamRealizationService service) {
        super(service);
        this.service = service;
    }
}
