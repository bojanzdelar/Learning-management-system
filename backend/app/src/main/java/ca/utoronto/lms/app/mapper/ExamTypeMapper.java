package ca.utoronto.lms.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.lms.app.dto.ExamTypeDTO;
import ca.utoronto.lms.app.model.ExamType;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper extends BaseMapper<ExamType, ExamTypeDTO> {}
