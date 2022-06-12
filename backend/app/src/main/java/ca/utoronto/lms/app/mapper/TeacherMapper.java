package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.TeacherDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Teacher;
import ca.utoronto.lms.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
