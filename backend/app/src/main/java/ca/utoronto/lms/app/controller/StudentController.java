package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.StudentDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.model.Student;
import ca.utoronto.lms.app.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController extends BaseController<Student, StudentDTO, Long> {
    private final StudentService service;

    public StudentController(StudentService service) {
        super(service);
        this.service = service;
    }
}
