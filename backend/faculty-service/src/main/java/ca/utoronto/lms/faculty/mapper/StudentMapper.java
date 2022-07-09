package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.dto.ThesisDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<Student, StudentDTO, Long> {
    @Mapping(source = "userId", target = "user")
    StudentDTO toDTO(Student student);

    @Mapping(source = "user.id", target = "userId")
    Student toModel(StudentDTO studentDTO);

    UserDTO userDTOFromId(Long id);

    @Mapping(target = "student", ignore = true)
    ThesisDTO toDTO(Thesis thesis);

    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "manager", ignore = true)
    StudyProgramDTO toDTO(StudyProgram studyProgram);
}
