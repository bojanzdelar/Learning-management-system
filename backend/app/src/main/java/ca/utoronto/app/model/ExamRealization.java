package ca.utoronto.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamRealization extends BaseEntity<Long> {
    private Integer score;

    @ManyToOne(optional = false)
    private ExamTerm examTerm;

    @ManyToOne(optional = false)
    private SubjectEnrollment subjectEnrollment;
}
