package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.ThesisDTO;
import ca.utoronto.app.model.Thesis;
import ca.utoronto.app.service.ThesisService;

@RestController
@RequestMapping("/api/thesis")
public class ThesisController extends BaseController<Thesis, ThesisDTO, Long> {
    private final ThesisService service;

    public ThesisController(ThesisService service) {
        super(service);
        this.service = service;
    }
}
