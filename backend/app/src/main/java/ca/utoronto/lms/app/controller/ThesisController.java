package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.service.ThesisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.ThesisDTO;
import ca.utoronto.lms.app.model.Thesis;

@RestController
@RequestMapping("/api/thesis")
public class ThesisController extends BaseController<Thesis, ThesisDTO, Long> {
    private final ThesisService service;

    public ThesisController(ThesisService service) {
        super(service);
        this.service = service;
    }
}
