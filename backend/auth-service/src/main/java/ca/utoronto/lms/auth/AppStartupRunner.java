package ca.utoronto.lms.auth;

import ca.utoronto.lms.auth.service.RoleService;
import ca.utoronto.lms.auth.service.UserService;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AppStartupRunner implements ApplicationRunner {
    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        RoleDTO root =
                RoleDTO.builder()
                        .id(SecurityUtils.ROLE_ROOT_ID)
                        .authority(SecurityUtils.ROLE_ROOT)
                        .build();
        RoleDTO admin =
                RoleDTO.builder()
                        .id(SecurityUtils.ROLE_ADMIN_ID)
                        .authority(SecurityUtils.ROLE_ADMIN)
                        .build();
        RoleDTO teacher =
                RoleDTO.builder()
                        .id(SecurityUtils.ROLE_TEACHER_ID)
                        .authority(SecurityUtils.ROLE_TEACHER)
                        .build();
        RoleDTO student =
                RoleDTO.builder()
                        .id(SecurityUtils.ROLE_STUDENT_ID)
                        .authority(SecurityUtils.ROLE_STUDENT)
                        .build();

        UserDetailsDTO user =
                UserDetailsDTO.builder()
                        .id(1337L)
                        .username("admin@utoronto.ca")
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
