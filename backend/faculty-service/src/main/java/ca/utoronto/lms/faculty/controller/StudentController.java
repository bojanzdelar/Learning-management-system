package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.service.StudentService;
import ca.utoronto.lms.faculty.util.StudentPDFExporter;
import ca.utoronto.lms.faculty.util.StudentsOnSubjectPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController<Student, StudentDTO, Long> {
    private final StudentService service;
    private final StudentPDFExporter studentPDFExporter;
    private final StudentsOnSubjectPDFExporter studentsOnSubjectPDFExporter;

    public StudentController(
            StudentService service,
            StudentPDFExporter studentPDFExporter,
            StudentsOnSubjectPDFExporter studentsOnSubjectPDFExporter) {
        super(service);
        this.service = service;
        this.studentPDFExporter = studentPDFExporter;
        this.studentsOnSubjectPDFExporter = studentsOnSubjectPDFExporter;
    }

    @GetMapping(value = "/all/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAllPdf(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=students.pdf");
        List<StudentDTO> students = service.findAll();
        studentPDFExporter.export(students, response);
    }

    @GetMapping(value = "/subject/{id}/all")
    public ResponseEntity<List<StudentDTO>> getAllBySubjectId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/subject/{id}/all/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAllBySubjectIdPdf(@PathVariable Long id, HttpServletResponse response)
            throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=students-on-subject.pdf");
        List<StudentDTO> students = service.findBySubjectId(id);
        studentsOnSubjectPDFExporter.export(students, response);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<StudentDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(
                this.service.findBySubjectId(id, pageable, search), HttpStatus.OK);
    }

    @GetMapping("/user-id/{id}/id")
    public ResponseEntity<Long> getIdByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findIdByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/thesis/id")
    public ResponseEntity<Long> getThesisId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findThesisId(id), HttpStatus.OK);
    }
}
