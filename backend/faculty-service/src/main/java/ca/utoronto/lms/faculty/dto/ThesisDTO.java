package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ThesisDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "URL is mandatory")
    private String url;

    @NotNull(message = "Application date is mandatory")
    private LocalDate applicationDate;

    private LocalDate defenseDate;
    private Integer grade;

    @NotNull(message = "Student is mandatory")
    private StudentDTO student;

    @NotNull(message = "Teacher is mandatory")
    private TeacherDTO mentor;
}
