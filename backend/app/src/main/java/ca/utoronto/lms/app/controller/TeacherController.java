package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.TeacherDTO;
import ca.utoronto.lms.app.model.Teacher;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController extends BaseController<Teacher, TeacherDTO, Long> {
    private final TeacherService service;

    public TeacherController(TeacherService service) {
        super(service);
        this.service = service;
    }
}
