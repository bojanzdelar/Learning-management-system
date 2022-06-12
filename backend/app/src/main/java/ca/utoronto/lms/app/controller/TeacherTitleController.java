package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.TeacherTitleDTO;
import ca.utoronto.lms.app.model.TeacherTitle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.service.TeacherTitleService;

@RestController
@RequestMapping("/api/teacher-title")
public class TeacherTitleController extends BaseController<TeacherTitle, TeacherTitleDTO, Long> {
    private final TeacherTitleService service;

    public TeacherTitleController(TeacherTitleService service) {
        super(service);
        this.service = service;
    }
}
