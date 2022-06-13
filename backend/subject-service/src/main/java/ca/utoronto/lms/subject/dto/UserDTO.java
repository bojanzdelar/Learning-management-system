package ca.utoronto.lms.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO extends BaseDTO<Long> {
    private String email;
    private String firstName;
    private String lastName;
}
