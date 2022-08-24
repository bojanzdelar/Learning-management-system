package ca.utoronto.lms.exam.dto;

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
public class ExamPeriodDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Registration start date is mandatory")
    private LocalDate registrationStartDate;

    @NotNull(message = "Registration end date is mandatory")
    private LocalDate registrationEndDate;

    @NotNull(message = "Exam start date is mandatory")
    private LocalDate examStartDate;

    @NotNull(message = "Exam end date is mandatory")
    private LocalDate examEndDate;

    @NotNull(message = "Faculty is mandatory")
    private FacultyDTO faculty;
}
