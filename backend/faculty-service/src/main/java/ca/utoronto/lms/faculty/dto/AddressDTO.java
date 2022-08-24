package ca.utoronto.lms.faculty.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO extends BaseDTO<Long> {
    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotNull(message = "Number is mandatory")
    @Min(value = 1, message = "Number must be greater or equal to 1")
    private Integer number;

    @NotNull(message = "City is mandatory")
    private CityDTO city;
}
