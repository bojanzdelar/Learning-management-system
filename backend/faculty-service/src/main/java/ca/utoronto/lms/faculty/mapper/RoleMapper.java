package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.model.Role;
import org.mapstruct.Mapper;
import ca.utoronto.lms.faculty.dto.RoleDTO;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {}
