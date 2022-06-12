package ca.utoronto.lms.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectEnrollment extends BaseEntity<Long> {
    private Integer extraPoints;

    private Integer grade;

    @ManyToOne(optional = false)
    private Subject subject;

    @ManyToOne(optional = false)
    private Student student;

    @OneToMany(mappedBy = "subjectEnrollment")
    private Set<ExamRealization> examRealizations = new HashSet<>();
}
