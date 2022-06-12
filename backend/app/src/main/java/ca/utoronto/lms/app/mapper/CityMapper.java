package ca.utoronto.lms.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.lms.app.dto.CityDTO;
import ca.utoronto.lms.app.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper extends BaseMapper<City, CityDTO> {}
