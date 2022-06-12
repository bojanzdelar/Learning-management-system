package ca.utoronto.lms.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.lms.app.dto.CountryDTO;
import ca.utoronto.lms.app.model.Country;

@Mapper(componentModel = "spring")
public interface CountryMapper extends BaseMapper<Country, CountryDTO> {}
