package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.FacultyDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Faculty;
import ca.utoronto.lms.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacultyMapper extends BaseMapper<Faculty, FacultyDTO> {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
