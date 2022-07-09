package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.CityDTO;
import ca.utoronto.lms.faculty.model.City;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends BaseMapper<City, CityDTO, Long> {}
