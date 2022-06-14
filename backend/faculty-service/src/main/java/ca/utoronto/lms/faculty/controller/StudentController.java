package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/students")
public class StudentController extends BaseController<Student, StudentDTO, Long> {
    private final StudentService service;

    public StudentController(StudentService service) {
        super(service);
        this.service = service;
    }
}
