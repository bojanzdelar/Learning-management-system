package ca.utoronto.lms.exam.mapper;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.dto.SubjectEnrollmentDTO;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamRealizationMapper
        extends BaseMapper<ExamRealization, ExamRealizationDTO, Long> {
    @Mapping(source = "subjectEnrollmentId", target = "subjectEnrollment")
    ExamRealizationDTO toDTO(ExamRealization examRealization);

    @Mapping(source = "subjectEnrollment.id", target = "subjectEnrollmentId")
    ExamRealization toModel(ExamRealizationDTO examRealizationDTO);

    SubjectEnrollmentDTO subjectEnrollmentDTOFromId(Long id);

    @Mapping(target = "exam", ignore = true)
    @Mapping(target = "examPeriod", ignore = true)
    ExamTermDTO toDTO(ExamTerm examTerm);
}
