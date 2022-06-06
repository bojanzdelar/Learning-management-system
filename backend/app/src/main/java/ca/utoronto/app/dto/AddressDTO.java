package ca.utoronto.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO extends BaseDTO<Long> {
    private String street;
    private Integer number;
    private CityDTO city;
}
