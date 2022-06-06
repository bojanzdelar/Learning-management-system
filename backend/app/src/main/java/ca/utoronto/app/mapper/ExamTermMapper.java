package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.ExamDTO;
import ca.utoronto.app.dto.ExamPeriodDTO;
import ca.utoronto.app.dto.ExamTermDTO;
import ca.utoronto.app.model.Exam;
import ca.utoronto.app.model.ExamPeriod;
import ca.utoronto.app.model.ExamTerm;
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
