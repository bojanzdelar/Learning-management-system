package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.TeacherTitleDTO;
import ca.utoronto.lms.faculty.model.TeacherTitle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherTitleMapper extends BaseMapper<TeacherTitle, TeacherTitleDTO> {}
