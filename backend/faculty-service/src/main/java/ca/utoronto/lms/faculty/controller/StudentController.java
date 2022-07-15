package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.service.StudentService;
import ca.utoronto.lms.faculty.util.StudentPDFExporter;
import ca.utoronto.lms.faculty.util.StudentsOnSubjectPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/faculty-service/students")
public class StudentController extends BaseController<Student, StudentDTO, Long> {
    private final StudentService service;

    @Autowired private StudentPDFExporter studentPDFExporter;
    @Autowired private StudentsOnSubjectPDFExporter studentsOnSubjectPDFExporter;

    public StudentController(StudentService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(value = "/all/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAllPdf(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=students.pdf");
        List<StudentDTO> students = service.findAll();
        studentPDFExporter.export(students, response);
    }

    @GetMapping(value = "/all/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<StudentDTO>> getAllXml() {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/subject/{id}/all/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAllBySubjectIdPdf(@PathVariable Long id, HttpServletResponse response)
            throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=students-on-subject.pdf");
        List<StudentDTO> students = service.findBySubjectId(id);
        studentsOnSubjectPDFExporter.export(students, response);
    }

    @GetMapping(value = "/subject/{id}/all/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<StudentDTO>> getAllBySubjectIdXml(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<StudentDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        try {
            return new ResponseEntity<>(
                    this.service.findBySubjectId(id, pageable, search), HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user-id/{id}/id")
    public ResponseEntity<Long> getIdByUserId(@PathVariable Long id) {
        StudentDTO student = this.service.findByUserId(id);
        return student == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(student.getId(), HttpStatus.OK);
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
