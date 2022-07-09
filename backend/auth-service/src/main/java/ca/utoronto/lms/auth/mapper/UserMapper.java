package ca.utoronto.lms.auth.mapper;

import ca.utoronto.lms.auth.model.User;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDetailsDTO, Long> {
    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);

    List<UserDTO> userToUserDTOList(List<User> users);

    List<User> userDTOtoUserList(List<UserDTO> userDTOList);
}
