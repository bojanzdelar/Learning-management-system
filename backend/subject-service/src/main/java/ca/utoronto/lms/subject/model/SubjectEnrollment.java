package ca.utoronto.lms.subject.model;

import ca.utoronto.lms.shared.model.BaseEntity;
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
public class SubjectEnrollment extends BaseEntity<Long> {
    private Integer extraPoints;

    private Integer grade;

    private Long studentId;

    @ManyToOne(optional = false)
    private Subject subject;
}
