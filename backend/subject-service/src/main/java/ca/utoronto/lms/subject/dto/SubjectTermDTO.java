package ca.utoronto.lms.subject.dto;

import ca.utoronto.lms.shared.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectTermDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Start time is mandatory")
    private LocalDateTime startTime;

    @NotNull(message = "End time is mandatory")
    private LocalDateTime endTime;

    private TeacherDTO teacher;

    @NotBlank(message = "Description is mandatory")
    private SubjectDTO subject;
}
