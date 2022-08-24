package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO extends BaseDTO<Long> {
    @NotNull(message = "User is mandatory")
    private UserDTO user;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Index is mandatory")
    @Size(max = 45, message = "Index can't be longer than 45 characters")
    private String index;

    @NotNull(message = "Year of enrollment is mandatory")
    private Integer yearOfEnrollment;

    private ThesisDTO thesis;

    @NotNull(message = "Study program is mandatory")
    private StudyProgramDTO studyProgram;

    private Double averageGrade;
    private Integer totalECTS;
}
