package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.FacultyDTO;
import ca.utoronto.lms.app.model.Faculty;
import ca.utoronto.lms.app.service.FacultyService;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController extends BaseController<Faculty, FacultyDTO, Long> {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        super(service);
        this.service = service;
    }
}
