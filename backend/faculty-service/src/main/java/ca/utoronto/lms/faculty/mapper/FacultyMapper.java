package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.FacultyDTO;
import ca.utoronto.lms.faculty.model.Faculty;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper extends BaseMapper<Faculty, FacultyDTO, Long> {}
