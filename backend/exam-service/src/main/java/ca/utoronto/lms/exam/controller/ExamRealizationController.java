package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.service.ExamRealizationService;
import ca.utoronto.lms.exam.util.ExamRealizationPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exam-realizations")
public class ExamRealizationController
        extends BaseController<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationService service;
    private final ExamRealizationPDFExporter pdfExporter;

    public ExamRealizationController(
            ExamRealizationService service, ExamRealizationPDFExporter pdfExporter) {
        super(service);
        this.service = service;
        this.pdfExporter = pdfExporter;
    }

    @GetMapping("/exam-term/{id}")
    public ResponseEntity<Page<ExamRealizationDTO>> getByExamTermId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(service.findByExamTermId(id, pageable, search), HttpStatus.OK);
    }

    @GetMapping("/exam-term/{id}/all/pdf")
    public void getByExamTermIdPdf(@PathVariable Long id, HttpServletResponse response)
            throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=exam-realizations.pdf");
        List<ExamRealizationDTO> examRealizations = service.findByExamTermId(id);
        pdfExporter.export(examRealizations, response);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Page<ExamRealizationDTO>> getByStudentId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(service.findByStudentId(id, pageable, search), HttpStatus.OK);
    }

    @PostMapping("/exam-term/{id}")
    public ResponseEntity<List<ExamRealizationDTO>> createByExamTermId(
            @PathVariable Set<Long> examTermIds) {
        return new ResponseEntity<>(service.createByExamTermId(examTermIds), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/score")
    public ResponseEntity<ExamRealizationDTO> updateScore(
            @PathVariable Long id, @RequestBody ExamRealizationDTO examRealizationDTO) {
        return new ResponseEntity<>(
                this.service.updateScore(id, examRealizationDTO), HttpStatus.OK);
    }

    @PatchMapping("/exam-term/{id}/score")
    public ResponseEntity<List<ExamRealizationDTO>> updateScoresByExamTermId(
            @PathVariable Long id, @RequestBody List<ExamRealizationDTO> examRealizations) {
        return new ResponseEntity<>(
                service.updateScoresByExamTermId(id, examRealizations), HttpStatus.OK);
    }
}
