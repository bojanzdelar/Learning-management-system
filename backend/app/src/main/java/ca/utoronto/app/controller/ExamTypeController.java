package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.ExamTypeDTO;
import ca.utoronto.app.model.ExamType;
import ca.utoronto.app.service.ExamTypeService;

@RestController
@RequestMapping("/api/exam-type")
public class ExamTypeController extends BaseController<ExamType, ExamTypeDTO, Long> {
    private final ExamTypeService service;

    public ExamTypeController(ExamTypeService service) {
        super(service);
        this.service = service;
    }
}
