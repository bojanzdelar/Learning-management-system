package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.StudyProgramDTO;
import ca.utoronto.app.model.StudyProgram;
import ca.utoronto.app.service.StudyProgramService;

@RestController
@RequestMapping("/api/study-program")
public class StudyProgramController extends BaseController<StudyProgram, StudyProgramDTO, Long> {
    private final StudyProgramService service;

    public StudyProgramController(StudyProgramService service) {
        super(service);
        this.service = service;
    }
}
