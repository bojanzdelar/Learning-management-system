package ca.utoronto.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.dto.SubjectMaterialDTO;
import ca.utoronto.lms.subject.dto.TeacherDTO;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.model.SubjectMaterial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMaterialMapper
        extends BaseMapper<SubjectMaterial, SubjectMaterialDTO, Long> {
    @Mapping(source = "teacherId", target = "teacher")
    SubjectMaterialDTO toDTO(SubjectMaterial subjectMaterial);

    @Mapping(source = "teacher.id", target = "teacherId")
    SubjectMaterial toModel(SubjectMaterialDTO subjectMaterialDTO);

    TeacherDTO teacherDTOFromId(Long id);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);
}
