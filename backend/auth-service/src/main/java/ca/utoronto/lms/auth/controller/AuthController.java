package ca.utoronto.lms.auth.controller;

import ca.utoronto.lms.auth.dto.TokenDTO;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth-service")
@Slf4j
public class AuthController {
    @Autowired private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserDetailsDTO userDetailsDTO) {
        try {
            return new ResponseEntity<>(userService.login(userDetailsDTO), HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
