package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.client.UserFeignClient;
import ca.utoronto.lms.faculty.dto.AdministratorDTO;
import ca.utoronto.lms.faculty.mapper.AdministratorMapper;
import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.faculty.repository.AdministratorRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ca.utoronto.lms.shared.security.SecurityUtils.ROLE_ADMIN;
import static ca.utoronto.lms.shared.security.SecurityUtils.ROLE_ADMIN_ID;

@Service
public class AdministratorService extends ExtendedService<Administrator, AdministratorDTO, Long> {
    private final AdministratorRepository repository;
    private final AdministratorMapper mapper;
    private final UserFeignClient userFeignClient;

    public AdministratorService(
            AdministratorRepository repository,
            AdministratorMapper mapper,
            UserFeignClient userFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.userFeignClient = userFeignClient;
    }

    @Override
    @Transactional
    public AdministratorDTO save(AdministratorDTO administrator) {
        UserDTO userRequest = administrator.getUser();
        UserDTO userResponse =
                userRequest.getId() == null
                        ? userFeignClient.createUser(
                                UserDetailsDTO.builder()
                                        .username(userRequest.getUsername())
                                        .password(userRequest.getPassword())
                                        .authorities(
                                                Set.of(
                                                        RoleDTO.builder()
                                                                .id(ROLE_ADMIN_ID)
                                                                .authority(ROLE_ADMIN)
                                                                .build()))
                                        .build())
                        : userFeignClient.patchUser(userRequest.getId(), userRequest);
        administrator.setUser(userResponse);
        return super.save(administrator);
    }

    @Override
    @Transactional
    public void delete(Set<Long> id) {
        List<Administrator> administrators = (List<Administrator>) repository.findAllById(id);
        Set<Long> userIds =
                administrators.stream().map(Administrator::getUserId).collect(Collectors.toSet());
        userFeignClient.deleteUser(userIds);
        repository.softDeleteByIds(id);
    }

    @Override
    protected List<AdministratorDTO> mapMissingValues(List<AdministratorDTO> administrators) {
        map(
                administrators,
                AdministratorDTO::getUser,
                AdministratorDTO::setUser,
                userFeignClient::getUser);

        return administrators;
    }

    public AdministratorDTO findByUserId(Long userId) {
        Administrator administrator =
                repository
                        .findByUserId(userId)
                        .orElseThrow(() -> new NotFoundException("User id not found"));
        return mapper.toDTO(administrator);
    }
}
