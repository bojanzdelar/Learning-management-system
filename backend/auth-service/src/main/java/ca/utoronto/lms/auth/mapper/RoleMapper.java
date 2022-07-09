package ca.utoronto.lms.auth.mapper;

import ca.utoronto.lms.auth.model.Role;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO, Long> {}
