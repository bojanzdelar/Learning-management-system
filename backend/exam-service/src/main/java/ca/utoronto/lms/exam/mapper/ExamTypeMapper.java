package ca.utoronto.lms.exam.mapper;

import ca.utoronto.lms.exam.dto.ExamTypeDTO;
import ca.utoronto.lms.exam.model.ExamType;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper extends BaseMapper<ExamType, ExamTypeDTO, Long> {}
