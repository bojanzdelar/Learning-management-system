package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectMaterialDTO;
import ca.utoronto.lms.subject.model.SubjectMaterial;
import ca.utoronto.lms.subject.service.SubjectMaterialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-materials")
public class SubjectMaterialController
        extends BaseController<SubjectMaterial, SubjectMaterialDTO, Long> {
    private final SubjectMaterialService service;

    public SubjectMaterialController(SubjectMaterialService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}/all")
    public ResponseEntity<List<SubjectMaterialDTO>> getBySubjectId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<SubjectMaterialDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(
                this.service.findBySubjectId(id, pageable, search), HttpStatus.OK);
    }
}
