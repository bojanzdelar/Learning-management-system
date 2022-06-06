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
public class StudyProgram extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false)
    private Faculty faculty;

    @ManyToOne(optional = false)
    private Teacher manager;

    @OneToMany(mappedBy = "studyProgram")
    private Set<Subject> subjects = new HashSet<>();

    @OneToMany(mappedBy = "studyProgram")
    private Set<Student> students = new HashSet<>();
}
