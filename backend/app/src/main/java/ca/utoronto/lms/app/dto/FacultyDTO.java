package ca.utoronto.lms.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacultyDTO extends BaseDTO<Long> {
    private String name;
    private String description;
    private String email;
    private TeacherDTO dean;
    private AddressDTO address;
}
