package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.mapper.CountryMapper;
import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.CountryDTO;
import ca.utoronto.lms.app.model.Country;
import ca.utoronto.lms.app.repository.CountryRepository;

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
