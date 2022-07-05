package ca.utoronto.lms.auth.controller;

import ca.utoronto.lms.auth.dto.TokenDTO;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth-service")
public class AuthController {
    @Autowired private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserDetailsDTO userDetailsDTO) {
        TokenDTO tokenDTO = userService.login(userDetailsDTO);
        if (tokenDTO != null) {
            return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
