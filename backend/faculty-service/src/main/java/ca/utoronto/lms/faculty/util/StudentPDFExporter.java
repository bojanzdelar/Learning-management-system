package ca.utoronto.lms.faculty.util;

import ca.utoronto.lms.faculty.dto.StudentDTO;
import ca.utoronto.lms.shared.util.PDFExporter;
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
                    "Enrollment",
                    "Program",
                    "Grade",
                    "ECTS",
                },
                new float[] {1.5f, 4.5f, 3f, 3f, 3.5f, 1.75f, 1.75f, 1.75f, 1f},
                new ArrayList<>(
                        List.of(
                                student -> String.valueOf(student.getId()),
                                student -> student.getUser().getUsername(),
                                StudentDTO::getFirstName,
                                StudentDTO::getLastName,
                                StudentDTO::getIndex,
                                student -> String.valueOf(student.getYearOfEnrollment()),
                                student -> student.getStudyProgram().getAcronym(),
                                student -> String.valueOf(student.getAverageGrade()),
                                student -> String.valueOf(student.getTotalECTS()))));
    }
}
