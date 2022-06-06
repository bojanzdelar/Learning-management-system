package ca.utoronto.app.mapper;

import ca.utoronto.app.dto.SubjectDTO;
import ca.utoronto.app.dto.SubjectNotificationDTO;
import ca.utoronto.app.dto.UserDTO;
import ca.utoronto.app.model.Subject;
import ca.utoronto.app.model.SubjectNotification;
import ca.utoronto.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectNotificationMapper
        extends BaseMapper<SubjectNotification, SubjectNotificationDTO> {
    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);

    @Mapping(target = "role", ignore = true)
    UserDTO toDTO(User user);
}
