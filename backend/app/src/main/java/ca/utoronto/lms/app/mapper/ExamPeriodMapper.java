package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.ExamPeriodDTO;
import ca.utoronto.lms.app.dto.FacultyDTO;
import ca.utoronto.lms.app.model.ExamPeriod;
import ca.utoronto.lms.app.model.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamPeriodMapper extends BaseMapper<ExamPeriod, ExamPeriodDTO> {
    @Mapping(target = "dean", ignore = true)
    @Mapping(target = "address", ignore = true)
    FacultyDTO toDTO(Faculty faculty);
}
