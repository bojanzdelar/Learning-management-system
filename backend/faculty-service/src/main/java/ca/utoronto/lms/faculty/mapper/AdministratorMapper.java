package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.AdministratorDTO;
import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministratorMapper extends BaseMapper<Administrator, AdministratorDTO> {
    @Mapping(source = "userId", target = "user")
    AdministratorDTO toDTO(Administrator administrator);

    UserDTO userDTOFromId(Long id);
}
