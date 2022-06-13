package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.AddressDTO;
import ca.utoronto.lms.faculty.dto.CityDTO;
import ca.utoronto.lms.faculty.model.Address;
import ca.utoronto.lms.faculty.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {
    @Mapping(target = "country", ignore = true)
    CityDTO toDTO(City city);
}
