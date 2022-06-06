package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.FacultyDTO;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.Faculty;
import ca.utoronto.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacultyMapper extends BaseMapper<Faculty, FacultyDTO> {
    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
