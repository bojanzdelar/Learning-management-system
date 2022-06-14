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
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Address> addresses;
}
