package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<Student, StudentDTO> {
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "manager", ignore = true)
    StudyProgramDTO toDTO(StudyProgram studyProgram);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
