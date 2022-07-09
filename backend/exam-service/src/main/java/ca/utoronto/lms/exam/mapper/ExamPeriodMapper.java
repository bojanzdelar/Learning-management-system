package ca.utoronto.lms.exam.mapper;

import ca.utoronto.lms.exam.dto.ExamPeriodDTO;
import ca.utoronto.lms.exam.dto.FacultyDTO;
import ca.utoronto.lms.exam.model.ExamPeriod;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamPeriodMapper extends BaseMapper<ExamPeriod, ExamPeriodDTO, Long> {
    @Mapping(source = "facultyId", target = "faculty")
    ExamPeriodDTO toDTO(ExamPeriod examPeriod);

    @Mapping(source = "faculty.id", target = "facultyId")
    ExamPeriod toModel(ExamPeriodDTO examPeriodDTO);

    FacultyDTO facultyDTOFromId(Long id);
}
