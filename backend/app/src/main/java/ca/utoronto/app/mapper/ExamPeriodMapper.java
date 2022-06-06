package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.ExamPeriodDTO;
import ca.utoronto.app.dto.FacultyDTO;
import ca.utoronto.app.model.ExamPeriod;
import ca.utoronto.app.model.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamPeriodMapper extends BaseMapper<ExamPeriod, ExamPeriodDTO> {
    @Mapping(target = "dean", ignore = true)
    @Mapping(target = "address", ignore = true)
    FacultyDTO toDTO(Faculty faculty);
}
