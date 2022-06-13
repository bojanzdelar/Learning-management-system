package ca.utoronto.lms.exam.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.lms.exam.dto.ExamTypeDTO;
import ca.utoronto.lms.exam.model.ExamType;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper extends BaseMapper<ExamType, ExamTypeDTO> {}
