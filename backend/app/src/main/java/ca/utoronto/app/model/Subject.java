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
public class Subject extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String syllabus;

    @Column(nullable = false)
    private Integer semester;

    @Column(nullable = false)
    private Integer ects;

    @ManyToOne(optional = false)
    private StudyProgram studyProgram;

    @ManyToOne(optional = false)
    private Teacher professor;

    @ManyToOne(optional = false)
    private Teacher assistant;

    @OneToMany(mappedBy = "subject")
    private Set<Exam> exams = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectEnrollment> subjectEnrollments = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectNotification> subjectNotifications = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectMaterial> subjectMaterials = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectTerm> subjectTerms = new HashSet<>();
}
