package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.AddressDTO;
import ca.utoronto.app.dto.CityDTO;
import ca.utoronto.app.model.Address;
import ca.utoronto.app.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {
    @Mapping(target = "country", ignore = true)
    CityDTO toDTO(City city);
}
