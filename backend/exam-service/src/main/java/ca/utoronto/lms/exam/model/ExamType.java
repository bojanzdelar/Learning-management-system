package ca.utoronto.lms.exam.model;

import ca.utoronto.lms.shared.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamType extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "examType")
    private Set<Exam> exams = new HashSet<>();
}
