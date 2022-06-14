package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.shared.controller.BaseController;
import ca.utoronto.lms.faculty.dto.StudyProgramDTO;
import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.faculty.service.StudyProgramService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty-service/study-programs")
public class StudyProgramController extends BaseController<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramService service;

    public StudyProgramController(StudyProgramService service) {
        super(service);
        this.service = service;
    }
}
