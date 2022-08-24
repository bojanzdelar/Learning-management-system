package ca.utoronto.lms.exam.dto;

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
public class ExamDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Minimum score is mandatory")
    @Min(value = 0, message = "Minimum score must be greater or equal than 0")
    @Max(value = 90, message = "Minimum score must be less or equal than 90")
    private Integer minimumScore;

    @NotNull(message = "Maximum score is mandatory")
    @Min(value = 1, message = "Maximum score must be greater or equal than 1")
    @Max(value = 90, message = "Maximum score must be less or equal than 90")
    private Integer maximumScore;

    @NotNull(message = "Subject is mandatory")
    private SubjectDTO subject;

    @NotNull(message = "Exam type is mandatory")
    private ExamTypeDTO examType;
}
