package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectNotificationDTO;
import ca.utoronto.lms.subject.model.SubjectNotification;
import ca.utoronto.lms.subject.service.SubjectNotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-notifications")
public class SubjectNotificationController
        extends BaseController<SubjectNotification, SubjectNotificationDTO, Long> {
    private final SubjectNotificationService service;

    public SubjectNotificationController(SubjectNotificationService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}/all")
    public ResponseEntity<List<SubjectNotificationDTO>> getBySubjectId(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Page<SubjectNotificationDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(
                this.service.findBySubjectId(id, pageable, search), HttpStatus.OK);
    }
}
