package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.ThesisDTO;
import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.faculty.service.ThesisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/theses")
public class ThesisController extends BaseController<Thesis, ThesisDTO, Long> {
    private final ThesisService service;

    public ThesisController(ThesisService service) {
        super(service);
        this.service = service;
    }
}
