package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.TeacherTitleDTO;
import ca.utoronto.app.model.TeacherTitle;
import ca.utoronto.app.service.TeacherTitleService;

@RestController
@RequestMapping("/api/teacher-title")
public class TeacherTitleController extends BaseController<TeacherTitle, TeacherTitleDTO, Long> {
    private final TeacherTitleService service;

    public TeacherTitleController(TeacherTitleService service) {
        super(service);
        this.service = service;
    }
}
