package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String hashedPassword;

    private String firstName;
    private String lastName;
    private RoleDTO role;
}
