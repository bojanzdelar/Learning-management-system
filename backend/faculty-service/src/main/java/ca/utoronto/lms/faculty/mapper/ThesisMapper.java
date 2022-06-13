package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.dto.ThesisDTO;
import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.faculty.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThesisMapper extends BaseMapper<Thesis, ThesisDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    StudentDTO toDTO(Student student);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
