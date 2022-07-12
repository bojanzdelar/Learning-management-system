package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.SubjectNotificationDTO;
import ca.utoronto.lms.subject.dto.TeacherDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectNotificationMapper;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.model.SubjectNotification;
import ca.utoronto.lms.subject.repository.SubjectNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public SubjectNotificationDTO save(SubjectNotificationDTO subjectNotificationDTO) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            TeacherDTO teacher =
                    facultyFeignClient.getTeacherByUsername(SecurityUtils.getUsername());
            SubjectDTO subject = subjectNotificationDTO.getSubject();
            if (!subject.getProfessor().getId().equals(teacher.getId())
                    && !subject.getAssistant().getId().equals(teacher.getId())) {
                throw new RuntimeException(
                        "You are not authorized to add notifications to this subject");
            }

            if (subjectNotificationDTO.getTeacher() == null) {
                subjectNotificationDTO.setTeacher(teacher);
            }
        }

        return super.save(subjectNotificationDTO);
    }

    @Override
    public void delete(Set<Long> id) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            Long teacherId = SecurityUtils.getTeacherId();
            List<SubjectNotification> subjectNotifications =
                    (List<SubjectNotification>) repository.findAllById(id);
            boolean forbidden =
                    subjectNotifications.stream()
                            .anyMatch(
                                    subjectNotification -> {
                                        Subject subject = subjectNotification.getSubject();
                                        return !subject.getProfessorId().equals(teacherId)
                                                && !subject.getAssistantId().equals(teacherId);
                                    });
            if (forbidden) {
                throw new RuntimeException(
                        "You are not authorized to delete this notification"); // TODO: forbidden
            }
        }

        super.delete(id);
    }

    @Override
    protected List<SubjectNotificationDTO> mapMissingValues(
            List<SubjectNotificationDTO> subjectNotifications) {
        map(
                subjectNotifications,
                SubjectNotificationDTO::getTeacher,
                SubjectNotificationDTO::setTeacher,
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjectNotifications;
    }

    public List<SubjectNotificationDTO> findBySubjectId(Long id) {
        List<SubjectNotificationDTO> subjectNotifications =
                mapper.toDTO(
                        repository.findBySubjectIdAndDeletedFalseOrderByPublicationDateDesc(id));
        return subjectNotifications.isEmpty()
                ? subjectNotifications
                : this.mapMissingValues(subjectNotifications);
    }

    public Page<SubjectNotificationDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        Page<SubjectNotificationDTO> subjectNotifications =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return subjectNotifications.getContent().isEmpty()
                ? subjectNotifications
                : new PageImpl<>(
                        this.mapMissingValues(subjectNotifications.getContent()),
                        pageable,
                        subjectNotifications.getTotalElements());
    }
}
