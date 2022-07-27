package ca.utoronto.lms.auth.controller;

import ca.utoronto.lms.auth.dto.TokenDTO;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth-service")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserDetailsDTO userDetailsDTO) {
        return new ResponseEntity<>(userService.login(userDetailsDTO), HttpStatus.OK);
    }
}
