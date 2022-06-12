package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User, UserDTO, Long> {
    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }
}
