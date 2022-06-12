package ca.utoronto.lms.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.app.dto.AddressDTO;
import ca.utoronto.lms.app.mapper.AddressMapper;
import ca.utoronto.lms.app.model.Address;
import ca.utoronto.lms.app.repository.AddressRepository;

@Service
public class AddressService extends BaseService<Address, AddressDTO, Long> {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
