package ca.utoronto.lms.exam.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamRealizationDTO extends BaseDTO<Long> {
    private SubjectEnrollmentDTO subjectEnrollment;
    private ExamTermDTO examTerm;
    private Integer score;
    private Boolean passed;
}
