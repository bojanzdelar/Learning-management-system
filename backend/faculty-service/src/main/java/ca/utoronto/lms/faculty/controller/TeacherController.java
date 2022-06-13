package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.faculty.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/teachers")
public class TeacherController extends BaseController<Teacher, TeacherDTO, Long> {
    private final TeacherService service;

    public TeacherController(TeacherService service) {
        super(service);
        this.service = service;
    }
}
