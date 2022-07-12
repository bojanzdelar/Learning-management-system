package ca.utoronto.lms.exam.controller;

import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.exam.service.ExamTermService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exam-service/exam-terms")
public class ExamTermController extends BaseController<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermService service;

    public ExamTermController(ExamTermService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}/all")
    public ResponseEntity<List<ExamTermDTO>> getBySubjectId(@PathVariable Long id) {
        List<ExamTermDTO> examTerms = this.service.findBySubjectId(id);
        return examTerms.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(examTerms, HttpStatus.OK);
    }

    @GetMapping("/teacher/{username}/all")
    public ResponseEntity<List<ExamTermDTO>> getByTeacherUsername(@PathVariable String username) {
        List<ExamTermDTO> examTerms = this.service.findByTeacherUsername(username);
        return examTerms.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(examTerms, HttpStatus.OK);
    }
}
