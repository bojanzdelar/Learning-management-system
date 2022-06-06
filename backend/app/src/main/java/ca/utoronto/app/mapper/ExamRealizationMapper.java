package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.ExamRealizationDTO;
import ca.utoronto.app.dto.ExamTermDTO;
import ca.utoronto.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.app.model.ExamRealization;
import ca.utoronto.app.model.ExamTerm;
import ca.utoronto.app.model.SubjectEnrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamRealizationMapper extends BaseMapper<ExamRealization, ExamRealizationDTO> {
    @Mapping(target = "exam", ignore = true)
    @Mapping(target = "examPeriod", ignore = true)
    ExamTermDTO toDTO(ExamTerm examTerm);

    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "student", ignore = true)
    SubjectEnrollmentDTO toDTO(SubjectEnrollment subjectEnrollment);
}
