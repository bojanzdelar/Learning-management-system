package ca.utoronto.lms.faculty.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.lms.faculty.dto.CityDTO;
import ca.utoronto.lms.faculty.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper extends BaseMapper<City, CityDTO> {}
