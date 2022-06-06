package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.SubjectNotificationDTO;
import ca.utoronto.app.model.SubjectNotification;
import ca.utoronto.app.service.SubjectNotificationService;

@RestController
@RequestMapping("/api/subject-notification")
public class SubjectNotificationController
        extends BaseController<SubjectNotification, SubjectNotificationDTO, Long> {
    private final SubjectNotificationService service;

    public SubjectNotificationController(SubjectNotificationService service) {
        super(service);
        this.service = service;
    }
}
