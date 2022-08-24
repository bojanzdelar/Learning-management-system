package ca.utoronto.lms.subject.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Syllabus is mandatory")
    private String syllabus;

    @NotNull(message = "Semester is mandatory")
    @Min(value = 1, message = "Semester must be greater than or equal to 1")
    @Max(value = 8, message = "Semester must be less than or equal to 8")
    private Integer semester;

    @NotNull(message = "ECTS is mandatory")
    @Min(value = 1, message = "ECTS must be greater than or equal to 1")
    @Max(value = 10, message = "ECTS must be less than or equal to 10")
    private Integer ects;

    @NotNull(message = "Study program is mandatory")
    private StudyProgramDTO studyProgram;

    @NotNull(message = "Professor is mandatory")
    private TeacherDTO professor;

    @NotNull(message = "Assistant is mandatory")
    private TeacherDTO assistant;
}
