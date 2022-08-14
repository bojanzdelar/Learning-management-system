package ca.utoronto.lms.auth.security;

import ca.utoronto.lms.auth.client.FacultyFeignClient;
import ca.utoronto.lms.auth.model.User;
import ca.utoronto.lms.auth.repository.UserRepository;
import ca.utoronto.lms.shared.exception.BadRequestException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Component
@RequiredArgsConstructor
public class TokenGenerator {
    private final UserRepository userRepository;
    private final FacultyFeignClient facultyFeignClient;

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private Long expiration;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, userDetails.getUsername());
        claims.put(Claims.ISSUED_AT, new Date(System.currentTimeMillis()));

        User user =
                userRepository
                        .findByUsername(userDetails.getUsername())
                        .orElseThrow(() -> new NotFoundException("User not found"));
        if (user.isDeleted()) {
            throw new BadRequestException("User is deleted");
        }

        Long userId = user.getId();
        claims.put("userId", userId);

        List<String> authorities =
                userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        claims.put("roles", authorities);

        if (authorities.contains(ROLE_ADMIN)) {
            claims.put("adminId", facultyFeignClient.getAdministratorIdByUserId(userId));
        } else if (authorities.contains(ROLE_TEACHER)) {
            claims.put("teacherId", facultyFeignClient.getTeacherIdByUserId(userId));
        } else if (authorities.contains(ROLE_STUDENT)) {
            claims.put("studentId", facultyFeignClient.getStudentIdByUserId(userId));
        }

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
