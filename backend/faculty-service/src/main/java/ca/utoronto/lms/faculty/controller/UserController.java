package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.User;
import ca.utoronto.lms.faculty.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/users")
public class UserController extends BaseController<User, UserDTO, Long> {
    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }
}
