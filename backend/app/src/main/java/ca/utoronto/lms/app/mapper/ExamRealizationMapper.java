package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.ExamRealizationDTO;
import ca.utoronto.lms.app.dto.ExamTermDTO;
import ca.utoronto.lms.app.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.app.model.ExamRealization;
import ca.utoronto.lms.app.model.ExamTerm;
import ca.utoronto.lms.app.model.SubjectEnrollment;
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
