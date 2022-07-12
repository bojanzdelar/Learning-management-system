package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import ca.utoronto.lms.subject.service.SubjectEnrollmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject-service/subject-enrollments")
public class SubjectEnrollmentController
        extends BaseController<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentService service;

    public SubjectEnrollmentController(SubjectEnrollmentService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<SubjectEnrollmentDTO>> getBySubjectId(
            @PathVariable Long id, Pageable pageable, String search) {
        try {
            Page<SubjectEnrollmentDTO> subjectEnrollments =
                    this.service.findBySubjectId(id, pageable, search);
            return subjectEnrollments.isEmpty()
                    ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                    : new ResponseEntity<>(subjectEnrollments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/subject/{id}/student-id/all")
    public ResponseEntity<List<Long>> getStudentIdsBySubjectId(
            @PathVariable Long id, Pageable pageable, String search) {
        try {
            List<Long> studentsIds = this.service.findStudentsIdsBySubjectId(id);
            return studentsIds.isEmpty()
                    ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                    : new ResponseEntity<>(studentsIds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
