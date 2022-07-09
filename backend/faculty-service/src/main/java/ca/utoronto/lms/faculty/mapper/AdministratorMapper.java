package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.AdministratorDTO;
import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministratorMapper extends BaseMapper<Administrator, AdministratorDTO, Long> {
    @Mapping(source = "userId", target = "user")
    AdministratorDTO toDTO(Administrator administrator);

    @Mapping(source = "user.id", target = "userId")
    Administrator toModel(AdministratorDTO administratorDTO);

    UserDTO userDTOFromId(Long id);
}
