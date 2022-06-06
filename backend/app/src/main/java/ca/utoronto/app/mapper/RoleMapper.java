package ca.utoronto.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.app.dto.RoleDTO;
import ca.utoronto.app.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {}
