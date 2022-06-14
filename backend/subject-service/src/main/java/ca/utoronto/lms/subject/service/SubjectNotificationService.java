package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.shared.service.ExtendedService;
import ca.utoronto.lms.subject.dto.SubjectNotificationDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectNotificationMapper;
import ca.utoronto.lms.subject.model.SubjectNotification;
import ca.utoronto.lms.subject.repository.SubjectNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectNotificationService
        extends ExtendedService<SubjectNotification, SubjectNotificationDTO, Long> {
    private final SubjectNotificationRepository repository;
    private final SubjectNotificationMapper mapper;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectNotificationService(
            SubjectNotificationRepository repository, SubjectNotificationMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<SubjectNotificationDTO> mapMissingValues(
            List<SubjectNotificationDTO> subjectNotifications) {
        map(
                subjectNotifications,
                (subjectNotification) -> subjectNotification.getTeacher(),
                (subjectNotification, teacher) -> subjectNotification.setTeacher(teacher),
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjectNotifications;
    }
}
