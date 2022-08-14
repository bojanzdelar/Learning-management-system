package ca.utoronto.lms.faculty.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("subject-service")
public interface SubjectFeignClient {
    @GetMapping("/subject-enrollments/subject/{id}/student-id/all")
    List<Long> getStudentIdsBySubjectId(@PathVariable Long id);

    @GetMapping("/subject-enrollments/student/{id}/average-grade")
    List<Double> getAverageGradesByStudentId(@PathVariable List<Long> id);

    @GetMapping("/subject-enrollments/student/{id}/total-ects")
    List<Integer> getTotalECTSByStudentId(@PathVariable List<Long> id);
}
