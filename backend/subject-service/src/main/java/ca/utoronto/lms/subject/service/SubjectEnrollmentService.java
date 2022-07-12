package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectEnrollmentMapper;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import ca.utoronto.lms.subject.repository.SubjectEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectEnrollmentService
        extends ExtendedService<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    private final SubjectEnrollmentRepository repository;
    private final SubjectEnrollmentMapper mapper;

    @Autowired private SubjectService subjectService;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectEnrollmentService(
            SubjectEnrollmentRepository repository, SubjectEnrollmentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SubjectEnrollmentDTO> findById(Set<Long> ids) {
        List<SubjectEnrollment> subjectEnrollments =
                (List<SubjectEnrollment>) repository.findAllById(ids);

        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            List<Subject> subjects =
                    subjectEnrollments.stream().map(SubjectEnrollment::getSubject).toList();

            Long teacherId = SecurityUtils.getTeacherId();

            boolean forbidden =
                    subjects.stream()
                            .anyMatch(
                                    subject ->
                                            !subject.getProfessorId().equals(teacherId)
                                                    && !subject.getAssistantId().equals(teacherId));
            if (forbidden) {
                throw new RuntimeException("Forbidden"); // TODO: ForbiddenException
            }
        }

        List<SubjectEnrollmentDTO> subjectEnrollmentsDTO = mapper.toDTO(subjectEnrollments);
        return subjectEnrollmentsDTO.isEmpty()
                ? subjectEnrollmentsDTO
                : this.mapMissingValues(subjectEnrollmentsDTO);
    }

    @Override
    protected List<SubjectEnrollmentDTO> mapMissingValues(
            List<SubjectEnrollmentDTO> subjectEnrollments) {
        map(
                subjectEnrollments,
                SubjectEnrollmentDTO::getStudent,
                SubjectEnrollmentDTO::setStudent,
                (ID) -> facultyFeignClient.getStudent(ID));

        return subjectEnrollments;
    }

    public Page<SubjectEnrollmentDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            List<SubjectDTO> subjects = subjectService.findById(Set.of(id));
            if (subjects.isEmpty()) {
                return null; // TODO: NotFoundException
            }

            SubjectDTO subject = subjects.get(0);
            Long teacherId = SecurityUtils.getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new RuntimeException("Forbidden"); // TODO: ForbiddenException
            }
        }

        Page<SubjectEnrollmentDTO> subjectEnrollments =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);

        return subjectEnrollments.getContent().isEmpty()
                ? subjectEnrollments
                : new PageImpl<>(this.mapMissingValues(subjectEnrollments.getContent()), pageable, subjectEnrollments.getTotalElements());
    }

    public List<Long> findStudentsIdsBySubjectId(Long id) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            List<SubjectDTO> subjects = subjectService.findById(Set.of(id));
            if (subjects.isEmpty()) {
                throw new RuntimeException("Subject not found");
            }

            SubjectDTO subject = subjects.get(0);
            Long teacherId = SecurityUtils.getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new RuntimeException("You are not authorized to access this resource");
            }
        }

        return repository.findBySubjectId(id).stream()
                .map(SubjectEnrollment::getStudentId)
                .toList();
    }
}
