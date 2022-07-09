package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.faculty.dto.ThesisDTO;
import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThesisMapper extends BaseMapper<Thesis, ThesisDTO, Long> {
    @Mapping(target = "thesis", ignore = true)
    @Mapping(target = "studyProgram", ignore = true)
    StudentDTO toDTO(Student student);
}
