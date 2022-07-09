package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.dto.CountryDTO;
import ca.utoronto.lms.faculty.mapper.CountryMapper;
import ca.utoronto.lms.faculty.model.Country;
import ca.utoronto.lms.faculty.repository.CountryRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country, CountryDTO, Long> {
    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryService(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
