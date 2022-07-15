package ca.utoronto.lms.exam.util;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.shared.util.PDFExporter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamRealizationPDFExporter extends PDFExporter<ExamRealizationDTO, Long> {
    public ExamRealizationPDFExporter() {
        super(
                "Exam realization",
                new String[] {"ID", "Student", "Score", "Status"},
                new float[] {2f, 4f, 2f, 3f},
                new ArrayList<>(
                        List.of(
                                examRealization -> String.valueOf(examRealization.getId()),
                                examRealization ->
                                        String.format(
                                                "%s %s",
                                                examRealization
                                                        .getSubjectEnrollment()
                                                        .getStudent()
                                                        .getFirstName(),
                                                examRealization
                                                        .getSubjectEnrollment()
                                                        .getStudent()
                                                        .getLastName()),
                                examRealization ->
                                        examRealization.getScore() != null
                                                ? String.valueOf(examRealization.getScore())
                                                : "",
                                examRealization -> {
                                    Boolean passed = examRealization.getPassed();
                                    if (passed == null) return "";
                                    return passed ? "passed" : "failed";
                                })));
    }
}
