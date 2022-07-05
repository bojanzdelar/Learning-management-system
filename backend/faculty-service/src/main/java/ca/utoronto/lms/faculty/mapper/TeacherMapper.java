package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {
    @Mapping(source = "userId", target = "user")
    TeacherDTO toDTO(Teacher teacher);

    UserDTO userDTOFromId(Long id);
}
