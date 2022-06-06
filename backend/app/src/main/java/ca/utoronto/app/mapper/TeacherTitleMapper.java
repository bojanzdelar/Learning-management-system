package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.TeacherTitleDTO;
import ca.utoronto.app.model.TeacherTitle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherTitleMapper extends BaseMapper<TeacherTitle, TeacherTitleDTO> {}
