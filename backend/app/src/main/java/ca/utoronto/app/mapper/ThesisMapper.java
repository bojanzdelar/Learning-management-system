package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.StudentDTO;
import ca.utoronto.app.dto.ThesisDTO;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.Student;
import ca.utoronto.app.model.Thesis;
import ca.utoronto.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThesisMapper extends BaseMapper<Thesis, ThesisDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    StudentDTO toDTO(Student student);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
