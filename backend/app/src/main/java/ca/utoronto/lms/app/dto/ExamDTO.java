package ca.utoronto.lms.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamDTO extends BaseDTO<Long> {
    private String name;
    private String description;
    private Integer minimumScore;
    private Integer maximumScore;
    private SubjectDTO subject;
    private ExamTypeDTO examType;
}
