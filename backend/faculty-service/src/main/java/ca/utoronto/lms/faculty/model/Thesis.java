package ca.utoronto.lms.faculty.model;

import ca.utoronto.lms.shared.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Thesis extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private LocalDate applicationDate;

    private LocalDate defenseDate;

    private Integer grade;

    @OneToOne(optional = false)
    private Student student;

    @ManyToOne(optional = false)
    private Teacher mentor;
}
