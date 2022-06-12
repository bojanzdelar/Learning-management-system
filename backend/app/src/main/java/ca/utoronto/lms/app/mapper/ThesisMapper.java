package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.StudentDTO;
import ca.utoronto.lms.app.dto.ThesisDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Student;
import ca.utoronto.lms.app.model.Thesis;
import ca.utoronto.lms.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThesisMapper extends BaseMapper<Thesis, ThesisDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    StudentDTO toDTO(Student student);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
