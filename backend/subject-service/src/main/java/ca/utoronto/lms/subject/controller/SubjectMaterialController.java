package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectMaterialDTO;
import ca.utoronto.lms.subject.model.SubjectMaterial;
import ca.utoronto.lms.subject.service.SubjectMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject-service/subject-materials")
public class SubjectMaterialController
        extends BaseController<SubjectMaterial, SubjectMaterialDTO, Long> {
    private final SubjectMaterialService service;

    public SubjectMaterialController(SubjectMaterialService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<List<SubjectMaterialDTO>> getBySubjectId(@PathVariable Long id) {
        List<SubjectMaterialDTO> subjectMaterials = this.service.findBySubjectId(id);
        return subjectMaterials.isEmpty()
                ? new ResponseEntity(HttpStatus.NOT_FOUND)
                : new ResponseEntity(subjectMaterials, HttpStatus.OK);
    }
}
