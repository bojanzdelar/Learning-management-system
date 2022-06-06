package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.FacultyDTO;
import ca.utoronto.app.dto.StudyProgramDTO;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.Faculty;
import ca.utoronto.app.model.StudyProgram;
import ca.utoronto.app.model.User;
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
