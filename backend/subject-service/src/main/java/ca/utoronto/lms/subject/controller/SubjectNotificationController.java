package ca.utoronto.lms.subject.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.subject.dto.SubjectNotificationDTO;
import ca.utoronto.lms.subject.model.SubjectNotification;
import ca.utoronto.lms.subject.service.SubjectNotificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject-service/subject-notifications")
public class SubjectNotificationController
        extends BaseController<SubjectNotification, SubjectNotificationDTO, Long> {
    private final SubjectNotificationService service;

    public SubjectNotificationController(SubjectNotificationService service) {
        super(service);
        this.service = service;
    }
}
