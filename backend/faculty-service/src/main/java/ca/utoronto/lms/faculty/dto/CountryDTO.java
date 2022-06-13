package ca.utoronto.lms.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryDTO extends BaseDTO<Long> {
    private String name;
}
