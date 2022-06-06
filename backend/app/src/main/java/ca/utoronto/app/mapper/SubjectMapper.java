package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.StudyProgramDTO;
import ca.utoronto.app.dto.SubjectDTO;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.StudyProgram;
import ca.utoronto.app.model.Subject;
import ca.utoronto.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends BaseMapper<Subject, SubjectDTO> {
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "manager", ignore = true)
    StudyProgramDTO toDTO(StudyProgram studyProgram);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
