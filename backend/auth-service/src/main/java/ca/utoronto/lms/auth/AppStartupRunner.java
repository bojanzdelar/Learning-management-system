package ca.utoronto.lms.auth;

import ca.utoronto.lms.auth.service.RoleService;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppStartupRunner implements ApplicationRunner {
    @Autowired private RoleService roleService;
    @Autowired private UserService userService;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        RoleDTO root = RoleDTO.builder().id(1L).authority(SecurityConstants.ROLE_ROOT).build();
        RoleDTO admin = RoleDTO.builder().id(2L).authority(SecurityConstants.ROLE_ADMIN).build();
        RoleDTO teacher =
                RoleDTO.builder().id(3L).authority(SecurityConstants.ROLE_TEACHER).build();
        RoleDTO student =
                RoleDTO.builder().id(4L).authority(SecurityConstants.ROLE_STUDENT).build();

        UserDetailsDTO user =
                UserDetailsDTO.builder()
                        .id(1337L)
                        .username("admin@utoronto.ca")
                        .firstName("Bojan")
                        .lastName("Zdelar")
                        .password(passwordEncoder.encode("password"))
                        .authorities(Set.of(root, admin))
                        .build();

        if (roleService.findAll().isEmpty()) {
            roleService.save(root);
            roleService.save(admin);
            roleService.save(teacher);
            roleService.save(student);
        }

        if (userService.findAll().isEmpty()) {
            userService.save(user);
        }
    }
}
