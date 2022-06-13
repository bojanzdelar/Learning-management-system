package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.subject.dto.SubjectMaterialDTO;
import ca.utoronto.lms.subject.model.SubjectMaterial;
import ca.utoronto.lms.subject.service.SubjectMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject-service/subject-materials")
public class SubjectMaterialController
        extends BaseController<SubjectMaterial, SubjectMaterialDTO, Long> {
    private final SubjectMaterialService service;

    public SubjectMaterialController(SubjectMaterialService service) {
        super(service);
        this.service = service;
    }
}
