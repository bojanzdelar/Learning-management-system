package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.ExamRealizationDTO;
import ca.utoronto.lms.app.model.ExamRealization;
import ca.utoronto.lms.app.service.ExamRealizationService;

@RestController
@RequestMapping("/api/exam-realization")
public class ExamRealizationController
        extends BaseController<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationService service;

    public ExamRealizationController(ExamRealizationService service) {
        super(service);
        this.service = service;
    }
}
