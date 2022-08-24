package ca.utoronto.lms.exam.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamRealizationDTO extends BaseDTO<Long> {
    @NotNull(message = "Subject enrollment is mandatory")
    private SubjectEnrollmentDTO subjectEnrollment;

    @NotNull(message = "Subject enrollment is mandatory")
    private ExamTermDTO examTerm;

    @Min(value = 0, message = "Minimum score must be greater than 0")
    @Max(value = 90, message = "Maximum score must be greater than 90")
    private Integer score;

    private Boolean passed;
}
