package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.AdministratorDTO;
import ca.utoronto.lms.faculty.feign.UserFeignClient;
import ca.utoronto.lms.faculty.mapper.AdministratorMapper;
import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.faculty.repository.AdministratorRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdministratorService extends ExtendedService<Administrator, AdministratorDTO, Long> {
    private final AdministratorRepository repository;
    private final AdministratorMapper mapper;

    @Autowired private UserFeignClient userFeignClient;

    public AdministratorService(AdministratorRepository repository, AdministratorMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
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
                                                                .id(SecurityUtils.ROLE_ADMIN_ID)
                                                                .authority(SecurityUtils.ROLE_ADMIN)
                                                                .build()))
                                        .build())
                        : userFeignClient.patchUser(userRequest.getId(), userRequest);
        administrator.setUser(userResponse);
        return super.save(administrator);
    }

    @Override
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
                (ID) -> userFeignClient.getUser(ID));

        return administrators;
    }
}
