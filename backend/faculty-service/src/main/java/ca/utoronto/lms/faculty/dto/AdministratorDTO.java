package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdministratorDTO extends BaseDTO<Long> {
    @NotNull(message = "User is mandatory")
    private UserDTO user;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;
}
