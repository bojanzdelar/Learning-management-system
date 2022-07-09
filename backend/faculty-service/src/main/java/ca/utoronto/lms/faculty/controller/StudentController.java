package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.service.StudentService;
import ca.utoronto.lms.faculty.util.StudentPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/faculty-service/students")
public class StudentController extends BaseController<Student, StudentDTO, Long> {
    private final StudentService service;

    @Autowired private StudentPDFExporter pdfExporter;

    public StudentController(StudentService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(value = "/all/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAllPdf(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=students.pdf");
        List<StudentDTO> students = service.findAll();
        pdfExporter.export(students, response);
    }

    @GetMapping(value = "/all/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<StudentDTO>> getAllXml() {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/thesis/id")
    public ResponseEntity<Long> getThesisId(@PathVariable Long id) {
        StudentDTO student = this.service.findById(Set.of(id)).get(0);
        if (student == null || student.getThesis() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student.getThesis().getId(), HttpStatus.OK);
    }
}
