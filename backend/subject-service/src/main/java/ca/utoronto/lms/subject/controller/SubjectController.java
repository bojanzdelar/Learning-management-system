package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject-service/subjects")
public class SubjectController extends BaseController<Subject, SubjectDTO, Long> {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/study-program/{id}")
    public ResponseEntity<List<SubjectDTO>> getByStudyProgramId(@PathVariable Long id) {
        List<SubjectDTO> subjects = this.service.findByStudyProgramId(id);
        return subjects.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}
