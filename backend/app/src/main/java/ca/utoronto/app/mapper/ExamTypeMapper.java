package ca.utoronto.app.mapper;

import org.mapstruct.Mapper;
import ca.utoronto.app.dto.ExamTypeDTO;
import ca.utoronto.app.model.ExamType;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper extends BaseMapper<ExamType, ExamTypeDTO> {}
