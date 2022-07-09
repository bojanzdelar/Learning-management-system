package ca.utoronto.lms.faculty.util;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentPDFExporter extends PDFExporter<StudentDTO, Long> {
    public StudentPDFExporter() {
        super(
                "Student list",
                new String[] {
                    "ID",
                    "Username",
                    "First name",
                    "Last name",
                    "Index",
                    "Year of enrollment",
                    "Study program"
                },
                new float[] {1.5f, 3f, 3f, 3.5f, 3f, 2f, 4f},
                new ArrayList<>(
                        List.of(
                                student -> String.valueOf(student.getId()),
                                student -> student.getUser().getUsername(),
                                StudentDTO::getFirstName,
                                StudentDTO::getLastName,
                                StudentDTO::getIndex,
                                student -> String.valueOf(student.getYearOfEnrollment()),
                                student -> student.getStudyProgram().getName())));
    }
}
