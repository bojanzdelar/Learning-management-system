package ca.utoronto.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectTermDTO extends BaseDTO<Long> {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SubjectDTO subject;
    private TeacherDTO teacher;
}