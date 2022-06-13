package ca.utoronto.lms.exam.mapper;

import ca.utoronto.lms.exam.dto.ExamDTO;
import ca.utoronto.lms.exam.dto.ExamPeriodDTO;
import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.exam.model.ExamPeriod;
import ca.utoronto.lms.exam.model.ExamTerm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamTermMapper extends BaseMapper<ExamTerm, ExamTermDTO> {
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "examType", ignore = true)
    ExamDTO toDTO(Exam exam);

    @Mapping(target = "faculty", ignore = true)
    ExamPeriodDTO toDTO(ExamPeriod examPeriod);
}
