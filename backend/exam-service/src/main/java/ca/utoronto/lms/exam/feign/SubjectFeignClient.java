package ca.utoronto.lms.exam.feign;

import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.dto.SubjectEnrollmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@FeignClient("subject-service")
public interface SubjectFeignClient {
    @GetMapping("/api/subject-service/subjects/{id}")
    List<SubjectDTO> getSubject(@PathVariable Set<Long> id);

    @GetMapping("/api/subject-service/subjects/teacher/{username}/all")
    List<SubjectDTO> getSubjectByTeacherUsername(@PathVariable String username);

    @GetMapping("/api/subject-service/subject-enrollments/{id}")
    List<SubjectEnrollmentDTO> getSubjectEnrollment(@PathVariable Set<Long> id);
}
