package ca.utoronto.lms.faculty.feign;

import ca.utoronto.lms.shared.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@FeignClient(name = "auth-service", contextId = "userFeignClient")
public interface UserFeignClient {
    @GetMapping("/api/auth-service/users/{id}")
    List<UserDTO> getUser(@PathVariable Set<Long> id);
}
