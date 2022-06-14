package ca.utoronto.lms.subject.model;

import ca.utoronto.lms.shared.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
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

    @Column(nullable = false)
    private Long studyProgramId;

    @Column(nullable = false)
    private Long professorId;

    @Column(nullable = false)
    private Long assistantId;

    @OneToMany(mappedBy = "subject")
    private Set<SubjectEnrollment> subjectEnrollments = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectNotification> subjectNotifications = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectMaterial> subjectMaterials = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<SubjectTerm> subjectTerms = new HashSet<>();
}
