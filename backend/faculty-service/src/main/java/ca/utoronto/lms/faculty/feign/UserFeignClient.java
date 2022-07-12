package ca.utoronto.lms.faculty.feign;

import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(name = "auth-service", contextId = "userFeignClient")
public interface UserFeignClient {
    @GetMapping("/api/auth-service/users/{id}/public")
    List<UserDTO> getUser(@PathVariable Set<Long> id);

    @GetMapping("/api/auth-service/users/username/{username}/id")
    Long getUserIdByUsername(@PathVariable String username);

    @PostMapping("/api/auth-service/users")
    UserDTO createUser(UserDetailsDTO user);

    @PatchMapping("/api/auth-service/users/{id}")
    UserDTO patchUser(@PathVariable Long id, UserDTO user);

    @DeleteMapping("/api/auth-service/users/{id}")
    void deleteUser(@PathVariable Set<Long> id);
}
