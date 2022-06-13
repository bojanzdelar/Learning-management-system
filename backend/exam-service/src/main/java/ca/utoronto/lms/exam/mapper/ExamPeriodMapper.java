package ca.utoronto.lms.exam.mapper;

import ca.utoronto.lms.exam.dto.ExamPeriodDTO;
import ca.utoronto.lms.exam.dto.FacultyDTO;
import ca.utoronto.lms.exam.model.ExamPeriod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamPeriodMapper extends BaseMapper<ExamPeriod, ExamPeriodDTO> {
    @Mapping(source = "facultyId", target = "faculty")
    ExamPeriodDTO toDTO(ExamPeriod examPeriod);

    FacultyDTO facultyDTOFromId(Long id);
}
