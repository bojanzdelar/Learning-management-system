package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.StudentDTO;
import ca.utoronto.lms.app.dto.SubjectDTO;
import ca.utoronto.lms.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.app.model.Student;
import ca.utoronto.lms.app.model.Subject;
import ca.utoronto.lms.app.model.SubjectEnrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectEnrollmentMapper
        extends BaseMapper<SubjectEnrollment, SubjectEnrollmentDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "user", ignore = true)
    StudentDTO toDTO(Student student);
}
