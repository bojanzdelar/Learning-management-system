package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.SubjectDTO;
import ca.utoronto.lms.app.dto.SubjectTermDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Subject;
import ca.utoronto.lms.app.model.SubjectTerm;
import ca.utoronto.lms.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectTermMapper extends BaseMapper<SubjectTerm, SubjectTermDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
