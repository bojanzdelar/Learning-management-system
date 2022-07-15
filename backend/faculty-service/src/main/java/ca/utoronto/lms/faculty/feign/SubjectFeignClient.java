package ca.utoronto.lms.faculty.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("subject-service")
public interface SubjectFeignClient {
    @GetMapping("/api/subject-service/subject-enrollments/subject/{id}/student-id/all")
    List<Long> getStudentIdsBySubjectId(@PathVariable Long id);

    @GetMapping("/api/subject-service/subject-enrollments/student/{id}/average-grade")
    List<Double> getAverageGradesByStudentId(@PathVariable List<Long> id);

    @GetMapping("/api/subject-service/subject-enrollments/student/{id}/total-ects")
    List<Integer> getTotalECTSByStudentId(@PathVariable List<Long> id);
}
