package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.SubjectTermDTO;
import ca.utoronto.lms.subject.dto.TeacherDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectTermMapper;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.model.SubjectTerm;
import ca.utoronto.lms.subject.repository.SubjectTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectTermService extends ExtendedService<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermRepository repository;
    private final SubjectTermMapper mapper;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectTermService(SubjectTermRepository repository, SubjectTermMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SubjectTermDTO save(SubjectTermDTO subjectTermDTO) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            TeacherDTO teacher =
                    facultyFeignClient.getTeacherByUsername(SecurityUtils.getUsername());
            SubjectDTO subject = subjectTermDTO.getSubject();
            if (!subject.getProfessor().getId().equals(teacher.getId())
                    && !subject.getAssistant().getId().equals(teacher.getId())) {
                throw new RuntimeException("You are not authorized to add terms to this subject");
            }

            if (subjectTermDTO.getTeacher() == null) {
                subjectTermDTO.setTeacher(teacher);
            }
        }

        return super.save(subjectTermDTO);
    }

    @Override
    public void delete(Set<Long> id) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            Long teacherId = SecurityUtils.getTeacherId();
            List<SubjectTerm> subjectTerms = (List<SubjectTerm>) repository.findAllById(id);
            boolean forbidden =
                    subjectTerms.stream()
                            .anyMatch(
                                    subjectTerm -> {
                                        Subject subject = subjectTerm.getSubject();
                                        return !subject.getProfessorId().equals(teacherId)
                                                && !subject.getAssistantId().equals(teacherId);
                                    });
            if (forbidden) {
                throw new RuntimeException(
                        "You are not authorized to delete this term"); // TODO: forbidden
            }
        }

        super.delete(id);
    }

    @Override
    protected List<SubjectTermDTO> mapMissingValues(List<SubjectTermDTO> subjectTerms) {
        map(
                subjectTerms,
                SubjectTermDTO::getTeacher,
                SubjectTermDTO::setTeacher,
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjectTerms;
    }

    public List<SubjectTermDTO> findBySubjectId(Long id) {
        List<SubjectTermDTO> subjectTerms =
                mapper.toDTO(repository.findBySubjectIdAndDeletedFalseOrderByStartTimeDesc(id));
        return subjectTerms.isEmpty() ? subjectTerms : this.mapMissingValues(subjectTerms);
    }

    public Page<SubjectTermDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        Page<SubjectTermDTO> subjectTerms =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return subjectTerms.getContent().isEmpty()
                ? subjectTerms
                : new PageImpl<>(
                        this.mapMissingValues(subjectTerms.getContent()),
                        pageable,
                        subjectTerms.getTotalElements());
    }
}
