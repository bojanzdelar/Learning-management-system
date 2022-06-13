package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.mapper.UserMapper;
import ca.utoronto.lms.faculty.model.User;
import ca.utoronto.lms.faculty.repository.RoleRepository;
import ca.utoronto.lms.faculty.repository.UserRepository;
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
