package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.utoronto.lms.faculty.dto.CountryDTO;
import ca.utoronto.lms.faculty.model.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper extends BaseMapper<Country, CountryDTO> {}
