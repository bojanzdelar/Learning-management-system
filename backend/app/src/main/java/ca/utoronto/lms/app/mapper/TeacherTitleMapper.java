package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.TeacherTitleDTO;
import ca.utoronto.lms.app.model.TeacherTitle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherTitleMapper extends BaseMapper<TeacherTitle, TeacherTitleDTO> {}
