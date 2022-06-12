package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.StudentDTO;
import ca.utoronto.lms.app.dto.StudyProgramDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Student;
import ca.utoronto.lms.app.model.StudyProgram;
import ca.utoronto.lms.app.model.User;
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
