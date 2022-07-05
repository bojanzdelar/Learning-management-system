package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.AdministratorDTO;
import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.faculty.service.AdministratorService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/administrators")
public class AdministratorController extends BaseController<Administrator, AdministratorDTO, Long> {
    private final AdministratorService service;

    public AdministratorController(AdministratorService service) {
        super(service);
        this.service = service;
    }
}
