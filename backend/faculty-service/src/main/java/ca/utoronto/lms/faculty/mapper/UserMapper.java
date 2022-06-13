package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {}
