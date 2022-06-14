package ca.utoronto.lms.faculty.model;

import ca.utoronto.lms.shared.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
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
public class Address extends BaseEntity<Long> {
    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne(optional = false)
    private City city;

    @OneToMany(mappedBy = "address")
    private Set<Faculty> faculties = new HashSet<>();
}
