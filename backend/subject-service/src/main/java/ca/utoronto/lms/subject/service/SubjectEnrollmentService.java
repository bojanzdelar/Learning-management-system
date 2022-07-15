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
import ca.utoronto.lms.subject.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)) {
            Long studentId = SecurityUtils.getStudentId();
            boolean forbidden =
                    subjectEnrollments.stream()
                            .anyMatch(
                                    subjectEnrollment ->
                                            !subjectEnrollment.getStudentId().equals(studentId));
            if (forbidden) {
                throw new RuntimeException("Forbidden");
            }
        }

        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
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
                throw new RuntimeException("Forbidden");
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
        map(
                subjectEnrollments,
                (subjectEnrollment) -> subjectEnrollment.getSubject().getProfessor(),
                (subjectEnrollment, professor) ->
                        subjectEnrollment.getSubject().setProfessor(professor),
                (ID) -> facultyFeignClient.getTeacher(ID));
        map(
                subjectEnrollments,
                (subjectEnrollment) -> subjectEnrollment.getSubject().getAssistant(),
                (subjectEnrollment, assistant) ->
                        subjectEnrollment.getSubject().setAssistant(assistant),
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjectEnrollments;
    }

    public List<SubjectEnrollmentDTO> findByStudentId(Long id) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)
                && !id.equals(SecurityUtils.getStudentId())) {
            throw new RuntimeException("Forbidden");
        }

        List<SubjectEnrollmentDTO> subjectEnrollments =
                mapper.toDTO(repository.findByStudentIdAndDeletedFalse(id));
        return subjectEnrollments.isEmpty()
                ? subjectEnrollments
                : this.mapMissingValues(subjectEnrollments);
    }

    public Page<SubjectEnrollmentDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
            List<SubjectDTO> subjects = subjectService.findById(Set.of(id));
            if (subjects.isEmpty()) {
                throw new RuntimeException("Not found");
            }

            SubjectDTO subject = subjects.get(0);
            Long teacherId = SecurityUtils.getTeacherId();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new RuntimeException("Forbidden");
            }
        }

        Page<SubjectEnrollmentDTO> subjectEnrollments =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);

        return subjectEnrollments.getContent().isEmpty()
                ? subjectEnrollments
                : new PageImpl<>(
                        this.mapMissingValues(subjectEnrollments.getContent()),
                        pageable,
                        subjectEnrollments.getTotalElements());
    }

    public Page<SubjectEnrollmentDTO> findByStudentId(Long id, Pageable pageable, String search) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)
                && !id.equals(SecurityUtils.getStudentId())) {
            throw new RuntimeException("Forbidden");
        }

        Page<SubjectEnrollmentDTO> subjectEnrollments =
                repository
                        .findByStudentIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);

        return subjectEnrollments.getContent().isEmpty()
                ? subjectEnrollments
                : new PageImpl<>(
                        this.mapMissingValues(subjectEnrollments.getContent()),
                        pageable,
                        subjectEnrollments.getTotalElements());
    }

    public List<Long> findStudentsIdsBySubjectId(Long id) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
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

        return repository.findBySubjectIdAndDeletedFalse(id).stream()
                .map(SubjectEnrollment::getStudentId)
                .toList();
    }

    public List<Double> findAverageGradeByStudentId(List<Long> ids) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)
                && (ids.size() > 1 || !ids.contains(SecurityUtils.getStudentId()))) {
            throw new RuntimeException("Forbidden");
        }

        List<Double> averageGrades = new ArrayList<>(ids.size());
        ids.forEach(
                id -> {
                    List<SubjectEnrollment> subjectEnrollments =
                            repository.findByStudentIdAndDeletedFalse(id).stream()
                                    .filter(
                                            subjectEnrollment ->
                                                    subjectEnrollment.getGrade() != null)
                                    .toList();

                    averageGrades.add(
                            subjectEnrollments.isEmpty()
                                    ? null
                                    : Utility.roundToTwoDecimals(
                                            Double.valueOf(
                                                            subjectEnrollments.stream()
                                                                    .map(
                                                                            SubjectEnrollment
                                                                                    ::getGrade)
                                                                    .reduce(0, Integer::sum))
                                                    / subjectEnrollments.size()));
                });
        return averageGrades;
    }

    public List<Integer> findTotalECTSByStudentId(List<Long> ids) {
        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_STUDENT)
                && (ids.size() > 1 || !ids.contains(SecurityUtils.getStudentId()))) {
            throw new RuntimeException("Forbidden");
        }

        List<Integer> totalECTS = new ArrayList<>(ids.size());
        ids.forEach(
                id -> {
                    List<SubjectEnrollment> subjectEnrollments =
                            repository.findByStudentIdAndDeletedFalse(id).stream()
                                    .filter(
                                            subjectEnrollment ->
                                                    subjectEnrollment.getGrade() != null)
                                    .toList();

                    totalECTS.add(
                            subjectEnrollments.stream()
                                    .map(SubjectEnrollment::getSubject)
                                    .map(Subject::getEcts)
                                    .reduce(0, Integer::sum));
                });
        return totalECTS;
    }

    public SubjectEnrollmentDTO updateGrade(Long id, SubjectEnrollmentDTO subjectEnrollmentDTO) {
        SubjectEnrollment subjectEnrollment = repository.findById(id).orElseThrow();

        if (SecurityUtils.hasAuthority(SecurityUtils.ROLE_TEACHER)) {
            Subject subject = subjectEnrollment.getSubject();
            Long teacherId = SecurityUtils.getTeacherId();
            if (!subject.getProfessorId().equals(teacherId)
                    && !subject.getAssistantId().equals(teacherId)) {
                throw new RuntimeException("Forbidden");
            }
        }

        subjectEnrollment.setExtraPoints(subjectEnrollmentDTO.getExtraPoints());
        subjectEnrollment.setGrade(subjectEnrollmentDTO.getGrade());

        return mapper.toDTO(repository.save(subjectEnrollment));
    }
}
