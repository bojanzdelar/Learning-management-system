package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {}
