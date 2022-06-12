package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.SubjectDTO;
import ca.utoronto.lms.app.dto.SubjectMaterialDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Subject;
import ca.utoronto.lms.app.model.SubjectMaterial;
import ca.utoronto.lms.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMaterialMapper extends BaseMapper<SubjectMaterial, SubjectMaterialDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
