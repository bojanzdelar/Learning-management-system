package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.repository.RoleRepository;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.RoleDTO;
import ca.utoronto.lms.app.mapper.RoleMapper;
import ca.utoronto.lms.app.model.Role;

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
