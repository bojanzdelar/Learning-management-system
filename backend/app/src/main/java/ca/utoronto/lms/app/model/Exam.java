package ca.utoronto.lms.app.model;

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
public class Exam extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    private Integer minimumScore;

    @Column(nullable = false)
    private Integer maximumScore;

    @ManyToOne(optional = false)
    private Subject subject;

    @ManyToOne(optional = false)
    private ExamType examType;

    @OneToMany(mappedBy = "exam")
    private Set<ExamTerm> examTerms = new HashSet<>();
}
