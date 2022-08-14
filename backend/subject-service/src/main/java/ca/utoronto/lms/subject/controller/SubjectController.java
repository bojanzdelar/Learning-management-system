package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController extends BaseController<Subject, SubjectDTO, Long> {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/study-program/{id}/all")
    public ResponseEntity<List<SubjectDTO>> getByStudyProgramId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findByStudyProgramId(id), HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}/all")
    public ResponseEntity<List<SubjectDTO>> getByTeacherId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findByTeacherId(id), HttpStatus.OK);
    }

    @GetMapping("/student/{id}/all")
    public ResponseEntity<List<SubjectDTO>> getByStudentId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findByStudentId(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}/syllabus")
    public ResponseEntity<SubjectDTO> patchSyllabus(
            @PathVariable Long id, @RequestBody String syllabus) {
        return new ResponseEntity<>(this.service.updateSyllabus(id, syllabus), HttpStatus.OK);
    }
}
