package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import ca.utoronto.lms.subject.client.FacultyFeignClient;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.SubjectNotificationDTO;
import ca.utoronto.lms.subject.dto.TeacherDTO;
import ca.utoronto.lms.subject.mapper.SubjectNotificationMapper;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.model.SubjectNotification;
import ca.utoronto.lms.subject.repository.SubjectNotificationRepository;
import ca.utoronto.lms.subject.repository.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class SubjectNotificationService
        extends ExtendedService<SubjectNotification, SubjectNotificationDTO, Long> {
    private final SubjectNotificationRepository repository;
    private final SubjectNotificationMapper mapper;
    private final SubjectRepository subjectRepository;
    private final FacultyFeignClient facultyFeignClient;

    public SubjectNotificationService(
            SubjectNotificationRepository repository,
            SubjectNotificationMapper mapper,
            SubjectRepository subjectRepository,
            FacultyFeignClient facultyFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.subjectRepository = subjectRepository;
        this.facultyFeignClient = facultyFeignClient;
    }

    @Override
    @Transactional
    public SubjectNotificationDTO save(SubjectNotificationDTO subjectNotificationDTO) {
        if (hasAuthority(ROLE_TEACHER)) {
            TeacherDTO teacher = facultyFeignClient.getTeacher(Set.of(getTeacherId())).get(0);
            SubjectDTO subject = subjectNotificationDTO.getSubject();
            if (!subject.getProfessor().getId().equals(teacher.getId())
                    && !subject.getAssistant().getId().equals(teacher.getId())) {
                throw new ForbiddenException(
                        "You are not allowed to manage this subject notification");
            }

            if (subjectNotificationDTO.getTeacher() == null) {
                subjectNotificationDTO.setTeacher(teacher);
            }
        }

        return super.save(subjectNotificationDTO);
    }

    @Override
    @Transactional
    public void delete(Set<Long> id) {
        if (hasAuthority(ROLE_TEACHER)) {
            Long teacherId = getTeacherId();
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
                throw new ForbiddenException(
                        "You are not allowed to delete these subject notifications");
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
                facultyFeignClient::getTeacher);

        return subjectNotifications;
    }

    public List<SubjectNotificationDTO> findBySubjectId(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new NotFoundException("Subject not found");
        }

        List<SubjectNotificationDTO> subjectNotifications =
                mapper.toDTO(
                        repository.findBySubjectIdAndDeletedFalseOrderByPublicationDateDesc(id));
        return subjectNotifications.isEmpty()
                ? subjectNotifications
                : this.mapMissingValues(subjectNotifications);
    }

    public Page<SubjectNotificationDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        if (!subjectRepository.existsById(id)) {
            throw new NotFoundException("Subject not found");
        }

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
