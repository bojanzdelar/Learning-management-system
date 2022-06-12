package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.RoleDTO;
import ca.utoronto.lms.app.model.Role;
import ca.utoronto.lms.app.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController extends BaseController<Role, RoleDTO, Long> {
    private final RoleService service;

    public RoleController(RoleService service) {
        super(service);
        this.service = service;
    }
}
