package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.RoleDTO;
import ca.utoronto.lms.faculty.model.Role;
import ca.utoronto.lms.faculty.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/roles")
public class RoleController extends BaseController<Role, RoleDTO, Long> {
    private final RoleService service;

    public RoleController(RoleService service) {
        super(service);
        this.service = service;
    }
}
