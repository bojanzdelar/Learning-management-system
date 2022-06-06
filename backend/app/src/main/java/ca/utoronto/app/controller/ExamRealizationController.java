package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.ExamRealizationDTO;
import ca.utoronto.app.model.ExamRealization;
import ca.utoronto.app.service.ExamRealizationService;

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
