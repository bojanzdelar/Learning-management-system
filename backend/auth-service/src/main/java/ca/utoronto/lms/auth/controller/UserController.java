package ca.utoronto.lms.auth.controller;

import ca.utoronto.lms.auth.model.User;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserDetailsDTO, Long> {
    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/{id}/public")
    public ResponseEntity<List<UserDTO>> getPublic(@PathVariable Set<Long> id) {
        return new ResponseEntity<>(service.findByIdPublic(id), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDetails> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/username/{username}/id")
    public ResponseEntity<Long> getUserIdByUsername(@PathVariable String username) {
        return new ResponseEntity<>(service.findIdByUsername(username), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<UserDetailsDTO> patch(
            @PathVariable Long id, @RequestBody UserDetailsDTO DTO) {
        DTO.setId(id);
        return new ResponseEntity<>(this.service.update(DTO), HttpStatus.OK);
    }
}
