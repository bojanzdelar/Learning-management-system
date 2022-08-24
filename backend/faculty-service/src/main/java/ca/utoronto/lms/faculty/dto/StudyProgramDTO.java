package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudyProgramDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Acronym is mandatory")
    private String acronym;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Faculty is mandatory")
    private FacultyDTO faculty;

    @NotNull(message = "Manager is mandatory")
    private TeacherDTO manager;
}
