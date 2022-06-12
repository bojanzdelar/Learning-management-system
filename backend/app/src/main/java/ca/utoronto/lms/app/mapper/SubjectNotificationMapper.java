package ca.utoronto.lms.app.mapper;

import ca.utoronto.lms.app.dto.SubjectDTO;
import ca.utoronto.lms.app.dto.SubjectNotificationDTO;
import ca.utoronto.lms.app.dto.UserDTO;
import ca.utoronto.lms.app.model.Subject;
import ca.utoronto.lms.app.model.SubjectNotification;
import ca.utoronto.lms.app.model.User;
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
