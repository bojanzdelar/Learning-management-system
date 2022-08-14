package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import ca.utoronto.lms.subject.service.SubjectEnrollmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-enrollments")
public class SubjectEnrollmentController
        extends BaseController<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentService service;

    public SubjectEnrollmentController(SubjectEnrollmentService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/student/{id}/all")
    public ResponseEntity<List<SubjectEnrollmentDTO>> getByStudentId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByStudentId(id), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<SubjectEnrollmentDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(
                this.service.findBySubjectId(id, pageable, search), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Page<SubjectEnrollmentDTO>> getByStudentId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(
                this.service.findByStudentId(id, pageable, search), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}/student-id/all")
    public ResponseEntity<List<Long>> getStudentIdsBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(this.service.findStudentsIdsBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/student/{id}/average-grade")
    public ResponseEntity<List<Double>> getAverageGradeByStudentId(@PathVariable List<Long> id) {
        return new ResponseEntity<>(this.service.findAverageGradeByStudentId(id), HttpStatus.OK);
    }

    @GetMapping("/student/{id}/total-ects")
    public ResponseEntity<List<Integer>> getTotalECTSByStudentId(@PathVariable List<Long> id) {
        return new ResponseEntity<>(this.service.findTotalECTSByStudentId(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}/grade")
    public ResponseEntity<SubjectEnrollmentDTO> updateGrade(
            @PathVariable Long id, @RequestBody SubjectEnrollmentDTO subjectEnrollment) {
        return new ResponseEntity<>(this.service.updateGrade(id, subjectEnrollment), HttpStatus.OK);
    }
}
