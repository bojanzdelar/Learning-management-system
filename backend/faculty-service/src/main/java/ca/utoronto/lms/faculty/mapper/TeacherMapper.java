package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.TeacherDTO;
import ca.utoronto.lms.faculty.model.Teacher;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO, Long> {
    @Mapping(source = "userId", target = "user")
    TeacherDTO toDTO(Teacher teacher);

    @Mapping(source = "user.id", target = "userId")
    Teacher toModel(TeacherDTO teacherDTO);

    UserDTO userDTOFromId(Long id);
}
