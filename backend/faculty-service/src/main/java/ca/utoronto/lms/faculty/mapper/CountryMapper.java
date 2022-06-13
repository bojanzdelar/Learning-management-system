package ca.utoronto.lms.faculty.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.lms.faculty.dto.CountryDTO;
import ca.utoronto.lms.faculty.model.Country;

@Mapper(componentModel = "spring")
public interface CountryMapper extends BaseMapper<Country, CountryDTO> {}
