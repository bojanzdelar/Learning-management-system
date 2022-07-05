package ca.utoronto.lms.auth.service;

import ca.utoronto.lms.auth.mapper.RoleMapper;
import ca.utoronto.lms.auth.model.Role;
import ca.utoronto.lms.auth.repository.RoleRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

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
