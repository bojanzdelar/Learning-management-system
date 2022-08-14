package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.FacultyDTO;
import ca.utoronto.lms.faculty.model.Faculty;
import ca.utoronto.lms.faculty.service.FacultyService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
public class FacultyController extends BaseController<Faculty, FacultyDTO, Long> {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        super(service);
        this.service = service;
    }
}
