package ca.utoronto.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.utoronto.lms.subject.dto.StudentDTO;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectEnrollmentMapper
        extends BaseMapper<SubjectEnrollment, SubjectEnrollmentDTO> {
    @Mapping(source = "studentId", target = "student")
    SubjectEnrollmentDTO toDTO(SubjectEnrollment subjectEnrollment);

    StudentDTO studentDTOFromId(Long id);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);
}
