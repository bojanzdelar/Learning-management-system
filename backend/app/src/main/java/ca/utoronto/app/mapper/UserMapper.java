package ca.utoronto.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {}
