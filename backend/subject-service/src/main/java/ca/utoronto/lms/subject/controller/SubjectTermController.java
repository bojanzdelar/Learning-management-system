package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectTermDTO;
import ca.utoronto.lms.subject.model.SubjectTerm;
import ca.utoronto.lms.subject.service.SubjectTermService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-terms")
public class SubjectTermController extends BaseController<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermService service;

    public SubjectTermController(SubjectTermService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}/all")
    public ResponseEntity<List<SubjectTermDTO>> getBySubjectId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<SubjectTermDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(
                this.service.findBySubjectId(id, pageable, search), HttpStatus.OK);
    }
}
