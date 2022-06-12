package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.mapper.UserMapper;
import ca.utoronto.lms.app.model.User;
import ca.utoronto.lms.app.repository.RoleRepository;
import ca.utoronto.lms.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
