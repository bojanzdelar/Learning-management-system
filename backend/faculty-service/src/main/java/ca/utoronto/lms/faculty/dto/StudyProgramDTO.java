package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudyProgramDTO extends BaseDTO<Long> {
    private String name;
    private String description;
    private FacultyDTO faculty;
    private TeacherDTO manager;
}
