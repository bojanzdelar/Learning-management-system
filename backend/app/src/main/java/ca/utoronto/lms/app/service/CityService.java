package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.CityDTO;
import ca.utoronto.lms.app.mapper.CityMapper;
import ca.utoronto.lms.app.model.City;
import ca.utoronto.lms.app.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService extends BaseService<City, CityDTO, Long> {
    private final CityRepository repository;
    private final CityMapper mapper;

    public CityService(CityRepository repository, CityMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
