package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.utoronto.lms.faculty.dto.FacultyDTO;
import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.Faculty;
import ca.utoronto.lms.faculty.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacultyMapper extends BaseMapper<Faculty, FacultyDTO> {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
