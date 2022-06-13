package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.TeacherTitleDTO;
import ca.utoronto.lms.faculty.model.TeacherTitle;
import ca.utoronto.lms.faculty.service.TeacherTitleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/teacher-titles")
public class TeacherTitleController extends BaseController<TeacherTitle, TeacherTitleDTO, Long> {
    private final TeacherTitleService service;

    public TeacherTitleController(TeacherTitleService service) {
        super(service);
        this.service = service;
    }
}
