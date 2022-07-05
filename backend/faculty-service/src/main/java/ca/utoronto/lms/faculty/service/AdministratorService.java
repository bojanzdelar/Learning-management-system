package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.AdministratorDTO;
import ca.utoronto.lms.faculty.feign.UserFeignClient;
import ca.utoronto.lms.faculty.mapper.AdministratorMapper;
import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.faculty.repository.AdministratorRepository;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    protected List<AdministratorDTO> mapMissingValues(List<AdministratorDTO> administrators) {
        map(
                administrators,
                AdministratorDTO::getUser,
                AdministratorDTO::setUser,
                (ID) -> userFeignClient.getUser(ID));

        return administrators;
    }
}
