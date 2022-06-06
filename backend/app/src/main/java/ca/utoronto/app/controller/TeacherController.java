package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.TeacherDTO;
import ca.utoronto.app.model.Teacher;
import ca.utoronto.app.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController extends BaseController<Teacher, TeacherDTO, Long> {
    private final TeacherService service;

    public TeacherController(TeacherService service) {
        super(service);
        this.service = service;
    }
}
