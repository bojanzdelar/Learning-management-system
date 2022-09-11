package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.faculty.service.TeacherService;
import ca.utoronto.lms.faculty.util.TeacherPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends BaseController<Teacher, TeacherDTO, Long> {
    private final TeacherService service;
    private final TeacherPDFExporter pdfExporter;

    public TeacherController(TeacherService service, TeacherPDFExporter pdfExporter) {
        super(service);
        this.service = service;
        this.pdfExporter = pdfExporter;
    }

    @GetMapping(value = "/all/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAllPdf(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=teachers.pdf");
        List<TeacherDTO> teachers = service.findAll();
        pdfExporter.export(teachers, response);
    }

    @GetMapping("/user-id/{id}/id")
    public ResponseEntity<Long> getIdByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findByUserId(id).getId(), HttpStatus.OK);
    }
}
