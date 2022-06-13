package ca.utoronto.lms.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectNotificationDTO extends BaseDTO<Long> {
    private String name;
    private String description;
    private LocalDateTime publicationDate;
    private TeacherDTO teacher;
    private SubjectDTO subject;
}