package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.utoronto.lms.faculty.dto.RoleDTO;
import ca.utoronto.lms.faculty.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {}
