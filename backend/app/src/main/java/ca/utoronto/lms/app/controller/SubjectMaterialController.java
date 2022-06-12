package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.SubjectMaterialDTO;
import ca.utoronto.lms.app.model.SubjectMaterial;
import ca.utoronto.lms.app.service.SubjectMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject-material")
public class SubjectMaterialController
        extends BaseController<SubjectMaterial, SubjectMaterialDTO, Long> {
    private final SubjectMaterialService service;

    public SubjectMaterialController(SubjectMaterialService service) {
        super(service);
        this.service = service;
    }
}
