package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.RoleDTO;
import ca.utoronto.app.mapper.RoleMapper;
import ca.utoronto.app.model.Role;
import ca.utoronto.app.repository.RoleRepository;

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
