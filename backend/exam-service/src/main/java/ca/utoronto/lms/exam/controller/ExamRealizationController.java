package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.service.ExamRealizationService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exam-service/exam-realizations")
public class ExamRealizationController
        extends BaseController<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationService service;

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
            Page<ExamRealizationDTO> examRealizations =
                    this.service.findByExamTermId(id, pageable, search);
            return examRealizations.isEmpty()
                    ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                    : new ResponseEntity<>(examRealizations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
