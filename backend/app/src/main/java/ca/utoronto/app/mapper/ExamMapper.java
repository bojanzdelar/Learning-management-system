package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.ExamDTO;
import ca.utoronto.app.dto.SubjectDTO;
import ca.utoronto.app.model.Exam;
import ca.utoronto.app.model.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamMapper extends BaseMapper<Exam, ExamDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);
}
