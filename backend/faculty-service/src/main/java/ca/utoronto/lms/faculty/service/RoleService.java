package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.repository.RoleRepository;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.faculty.dto.RoleDTO;
import ca.utoronto.lms.faculty.mapper.RoleMapper;
import ca.utoronto.lms.faculty.model.Role;

@Service
public class RoleService extends BaseService<Role, RoleDTO, Long> {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleService(RoleRepository repository, RoleMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
