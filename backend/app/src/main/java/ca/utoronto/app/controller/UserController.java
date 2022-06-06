package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.User;
import ca.utoronto.app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User, UserDTO, Long> {
    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }
}
