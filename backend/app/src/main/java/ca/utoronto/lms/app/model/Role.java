package ca.utoronto.lms.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
}
