package ca.utoronto.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectEnrollmentDTO extends BaseDTO<Long> {
    private Integer extraPoints;
    private Integer grade;
    private SubjectDTO subject;
    private StudentDTO student;
}
