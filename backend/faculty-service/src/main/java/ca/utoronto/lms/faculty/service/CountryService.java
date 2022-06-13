package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.mapper.CountryMapper;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.faculty.dto.CountryDTO;
import ca.utoronto.lms.faculty.model.Country;
import ca.utoronto.lms.faculty.repository.CountryRepository;

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
