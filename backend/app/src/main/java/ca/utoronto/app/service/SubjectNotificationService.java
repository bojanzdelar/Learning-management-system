package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.SubjectNotificationDTO;
import ca.utoronto.app.mapper.SubjectNotificationMapper;
import ca.utoronto.app.model.SubjectNotification;
import ca.utoronto.app.repository.SubjectNotificationRepository;

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