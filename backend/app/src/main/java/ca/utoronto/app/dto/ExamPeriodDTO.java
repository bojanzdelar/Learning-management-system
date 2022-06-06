package ca.utoronto.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamPeriodDTO extends BaseDTO<Long> {
    private String name;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;
    private LocalDate examStartDate;
    private LocalDate examEndDate;
    private FacultyDTO faculty;
}
