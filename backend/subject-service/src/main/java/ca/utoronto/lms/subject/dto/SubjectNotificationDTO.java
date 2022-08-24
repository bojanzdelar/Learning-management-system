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
public class SubjectNotificationDTO extends BaseDTO<Long> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Publication date is mandatory")
    private LocalDateTime publicationDate;

    private TeacherDTO teacher;

    @NotNull(message = "Subject is mandatory")
    private SubjectDTO subject;
}
