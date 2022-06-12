package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.ExamTypeDTO;
import ca.utoronto.lms.app.model.ExamType;
import ca.utoronto.lms.app.service.ExamTypeService;

@RestController
@RequestMapping("/api/exam-type")
public class ExamTypeController extends BaseController<ExamType, ExamTypeDTO, Long> {
    private final ExamTypeService service;

    public ExamTypeController(ExamTypeService service) {
        super(service);
        this.service = service;
    }
}
