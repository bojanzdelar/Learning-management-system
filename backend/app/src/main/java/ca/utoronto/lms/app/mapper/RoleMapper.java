package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.model.Role;
import org.mapstruct.Mapper;
import ca.utoronto.lms.app.dto.RoleDTO;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {}
