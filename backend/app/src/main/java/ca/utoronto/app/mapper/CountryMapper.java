package ca.utoronto.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.app.dto.CountryDTO;
import ca.utoronto.app.model.Country;

@Mapper(componentModel = "spring")
public interface CountryMapper extends BaseMapper<Country, CountryDTO> {}
