package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.CityDTO;
import ca.utoronto.lms.faculty.mapper.CityMapper;
import ca.utoronto.lms.faculty.model.City;
import ca.utoronto.lms.faculty.repository.CityRepository;
import ca.utoronto.lms.shared.service.BaseService;
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
