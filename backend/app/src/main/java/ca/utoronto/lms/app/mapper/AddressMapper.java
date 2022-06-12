package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.AddressDTO;
import ca.utoronto.lms.app.dto.CityDTO;
import ca.utoronto.lms.app.model.Address;
import ca.utoronto.lms.app.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {
    @Mapping(target = "country", ignore = true)
    CityDTO toDTO(City city);
}
