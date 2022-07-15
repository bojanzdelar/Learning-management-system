package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.service.ExamRealizationService;
import ca.utoronto.lms.exam.util.ExamRealizationPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/exam-service/exam-realizations")
public class ExamRealizationController
        extends BaseController<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationService service;

    @Autowired private ExamRealizationPDFExporter pdfExporter;

    public ExamRealizationController(ExamRealizationService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/exam-term/{id}")
    public ResponseEntity<Page<ExamRealizationDTO>> getByExamTermId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        try {
            return new ResponseEntity<>(
                    service.findByExamTermId(id, pageable, search), HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
        try {
            return new ResponseEntity<>(
                    service.findByStudentId(id, pageable, search), HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exam-term/{id}")
    public ResponseEntity<List<ExamRealizationDTO>> createByExamTermId(@PathVariable Set<Long> id) {
        try {
            return new ResponseEntity<>(service.createByExamTermId(id), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}/score")
    public ResponseEntity<ExamRealizationDTO> updateScore(
            @PathVariable Long id, @RequestBody ExamRealizationDTO examRealizationDTO) {
        try {
            return new ResponseEntity<>(
                    this.service.updateScore(id, examRealizationDTO), HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/exam-term/{id}/score")
    public ResponseEntity<List<ExamRealizationDTO>> updateScoresByExamTermId(
            @PathVariable Long id, @RequestBody List<ExamRealizationDTO> examRealizations) {
        try {
            return new ResponseEntity<>(
                    service.updateScoresByExamTermId(id, examRealizations), HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
