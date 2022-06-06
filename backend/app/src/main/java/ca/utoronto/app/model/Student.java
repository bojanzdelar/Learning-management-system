package ca.utoronto.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity<Long> {
    @OneToOne private User user;

    @Column(name = "s_index", length = 45, nullable = false)
    private String index;

    @Column(nullable = false)
    private Integer yearOfEnrollment;

    @OneToOne private Thesis thesis;

    @ManyToOne(optional = false)
    private StudyProgram studyProgram;

    @OneToMany(mappedBy = "student")
    private Set<SubjectEnrollment> subjectEnrollments = new HashSet<>();
}
