package ca.utoronto.lms.faculty.mapper;

import ca.utoronto.lms.faculty.dto.FacultyDTO;
import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.dto.UserDTO;
import ca.utoronto.lms.faculty.model.Faculty;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudyProgramMapper extends BaseMapper<StudyProgram, StudyProgramDTO> {
    @Mapping(target = "dean", ignore = true)
    @Mapping(target = "address", ignore = true)
    FacultyDTO toDTO(Faculty faculty);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
