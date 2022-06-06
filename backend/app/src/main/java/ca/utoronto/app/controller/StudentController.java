package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.StudentDTO;
import ca.utoronto.app.model.Student;
import ca.utoronto.app.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController extends BaseController<Student, StudentDTO, Long> {
    private final StudentService service;

    public StudentController(StudentService service) {
        super(service);
        this.service = service;
    }
}
