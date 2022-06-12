package ca.utoronto.lms.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.StudyProgramDTO;
import ca.utoronto.lms.app.model.StudyProgram;
import ca.utoronto.lms.app.service.StudyProgramService;

@RestController
@RequestMapping("/api/study-program")
public class StudyProgramController extends BaseController<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramService service;

    public StudyProgramController(StudyProgramService service) {
        super(service);
        this.service = service;
    }
}
