package ca.utoronto.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.mapper.UserMapper;
import ca.utoronto.app.model.User;
import ca.utoronto.app.repository.RoleRepository;
import ca.utoronto.app.repository.UserRepository;

@Service
public class UserService extends BaseService<User, UserDTO, Long> {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired private RoleRepository roleRepository;

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
