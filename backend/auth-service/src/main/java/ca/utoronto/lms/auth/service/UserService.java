package ca.utoronto.lms.auth.service;

import ca.utoronto.lms.auth.dto.TokenDTO;
import ca.utoronto.lms.auth.mapper.UserMapper;
import ca.utoronto.lms.auth.model.User;
import ca.utoronto.lms.auth.repository.UserRepository;
import ca.utoronto.lms.auth.security.TokenGenerator;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.security.SecurityConstants;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDetailsDTO, Long> {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired private UserDetailsServiceImpl userDetailsService;
    @Autowired private TokenGenerator tokenGenerator;

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetailsDTO save(UserDetailsDTO userDetailsDTO) {
        userDetailsDTO.setAccountNonExpired(true);
        userDetailsDTO.setAccountNonLocked(true);
        userDetailsDTO.setCredentialsNonExpired(true);
        userDetailsDTO.setEnabled(true);
        return super.save(userDetailsDTO);
    }

    public UserDetailsDTO findByUsername(String username) throws UsernameNotFoundException {
        UserDetails authenticatedUser =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!authenticatedUser.getUsername().equals(username)
                && !authenticatedUser
                        .getAuthorities()
                        .contains(new RoleDTO(SecurityConstants.ROLE_ROOT))) {
            return null;
        }

        return (UserDetailsDTO) userDetailsService.loadUserByUsername(username);
    }

    public TokenDTO login(UserDetailsDTO userDetailsDTO) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        userDetailsDTO.getUsername(), userDetailsDTO.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(userDetailsDTO.getUsername());
            String jwt = tokenGenerator.generateToken(userDetails);
            return new TokenDTO(jwt);
        } catch (AuthenticationException e) {
            return null;
        }
    }
}
