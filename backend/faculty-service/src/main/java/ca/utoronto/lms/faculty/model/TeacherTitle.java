package ca.utoronto.lms.faculty.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherTitle extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "teacherTitle")
    private Set<Teacher> teachers;
}
