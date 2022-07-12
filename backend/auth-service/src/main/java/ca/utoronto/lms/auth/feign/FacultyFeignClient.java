package ca.utoronto.lms.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("faculty-service")
public interface FacultyFeignClient {
    @GetMapping("/api/faculty-service/administrators/user-id/{id}/id")
    Long getAdministratorIdByUserId(@PathVariable Long id);

    @GetMapping("/api/faculty-service/teachers/user-id/{id}/id")
    Long getTeacherIdByUserId(@PathVariable Long id);

    @GetMapping("/api/faculty-service/students/user-id/{id}/id")
    Long getStudentIdByUserId(@PathVariable Long id);
}
