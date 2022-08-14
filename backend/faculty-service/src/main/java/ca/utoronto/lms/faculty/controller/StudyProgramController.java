package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.service.StudyProgramService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/study-programs")
public class StudyProgramController extends BaseController<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramService service;

    public StudyProgramController(StudyProgramService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/faculty/{id}/all")
    public ResponseEntity<List<StudyProgramDTO>> getByFacultyId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByFacultyId(id), HttpStatus.OK);
    }
}
