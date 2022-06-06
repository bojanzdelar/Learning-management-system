package ca.utoronto.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.app.dto.CityDTO;
import ca.utoronto.app.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper extends BaseMapper<City, CityDTO> {}
