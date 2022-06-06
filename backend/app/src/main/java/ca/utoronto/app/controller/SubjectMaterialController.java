package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.SubjectMaterialDTO;
import ca.utoronto.app.model.SubjectMaterial;
import ca.utoronto.app.service.SubjectMaterialService;

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
