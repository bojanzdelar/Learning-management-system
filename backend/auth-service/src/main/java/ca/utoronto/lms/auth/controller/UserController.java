package ca.utoronto.lms.auth.controller;

import ca.utoronto.lms.auth.model.User;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth-service/users")
public class UserController extends BaseController<User, UserDetailsDTO, Long> {
    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDetails> getUserByUsername(@PathVariable String username) {
        UserDetails userDetails;
        try {
            userDetails = service.findByUsername(username);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (userDetails == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
