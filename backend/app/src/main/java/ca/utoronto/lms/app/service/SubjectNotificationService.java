package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.SubjectNotificationDTO;
import ca.utoronto.lms.app.mapper.SubjectNotificationMapper;
import ca.utoronto.lms.app.model.SubjectNotification;
import ca.utoronto.lms.app.repository.SubjectNotificationRepository;

@Service
public class SubjectNotificationService extends BaseService<SubjectNotification, SubjectNotificationDTO, Long> {
    private final SubjectNotificationRepository repository;
    private final SubjectNotificationMapper mapper;

    public SubjectNotificationService(SubjectNotificationRepository repository, SubjectNotificationMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}