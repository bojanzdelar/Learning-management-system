package ca.utoronto.lms.exam.mapper;

import ca.utoronto.lms.exam.dto.ExamDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.model.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamMapper extends BaseMapper<Exam, ExamDTO> {
    @Mapping(source = "subjectId", target = "subject")
    ExamDTO toDTO(Exam exam);

    SubjectDTO subjectDTOFromId(Long id);
}
