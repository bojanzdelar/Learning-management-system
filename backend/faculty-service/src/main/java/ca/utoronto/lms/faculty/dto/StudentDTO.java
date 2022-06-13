package ca.utoronto.lms.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO extends BaseDTO<Long> {
    private UserDTO user;
    private String index;
    private Integer yearOfEnrollment;
    private StudyProgramDTO studyProgram;
}
