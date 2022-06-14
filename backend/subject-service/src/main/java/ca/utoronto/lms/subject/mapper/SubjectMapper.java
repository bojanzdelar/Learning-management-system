package ca.utoronto.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.utoronto.lms.subject.dto.StudyProgramDTO;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.TeacherDTO;
import ca.utoronto.lms.subject.model.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends BaseMapper<Subject, SubjectDTO> {
    @Mapping(source = "studyProgramId", target = "studyProgram")
    @Mapping(source = "professorId", target = "professor")
    @Mapping(source = "assistantId", target = "assistant")
    SubjectDTO toDTO(Subject subject);

    StudyProgramDTO studyProgramDTOFromId(Long id);

    TeacherDTO teacherFromId(Long id);
}
