package ca.utoronto.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamTermDTO extends BaseDTO<Long> {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ExamDTO exam;
    private ExamPeriodDTO examPeriod;
}
