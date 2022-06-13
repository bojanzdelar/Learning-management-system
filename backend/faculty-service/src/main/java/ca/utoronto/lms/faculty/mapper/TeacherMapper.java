package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.faculty.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
