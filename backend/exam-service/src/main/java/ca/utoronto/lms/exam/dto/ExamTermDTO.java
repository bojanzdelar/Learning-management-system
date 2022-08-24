package ca.utoronto.lms.exam.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamTermDTO extends BaseDTO<Long> {
    @NotNull(message = "Start time is mandatory")
    private LocalDateTime startTime;

    @NotNull(message = "End time is mandatory")
    private LocalDateTime endTime;

    @NotNull(message = "Exam is mandatory")
    private ExamDTO exam;

    @NotNull(message = "Exam period is mandatory")
    private ExamPeriodDTO examPeriod;
}
