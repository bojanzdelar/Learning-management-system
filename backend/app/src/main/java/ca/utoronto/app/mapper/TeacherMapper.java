package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.TeacherDTO;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.Teacher;
import ca.utoronto.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
