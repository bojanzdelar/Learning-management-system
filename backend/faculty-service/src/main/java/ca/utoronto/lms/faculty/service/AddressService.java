package ca.utoronto.lms.faculty.service;

import org.springframework.stereotype.Service;
import ca.utoronto.lms.faculty.dto.AddressDTO;
import ca.utoronto.lms.faculty.mapper.AddressMapper;
import ca.utoronto.lms.faculty.model.Address;
import ca.utoronto.lms.faculty.repository.AddressRepository;

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
