package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.subject.dto.SubjectDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectMapper;
import ca.utoronto.lms.subject.model.Subject;
import ca.utoronto.lms.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService extends ExtendedService<Subject, SubjectDTO, Long> {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectService(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    protected List<SubjectDTO> mapMissingValues(List<SubjectDTO> subjects) {
        map(
                subjects,
                (subject) -> subject.getStudyProgram(),
                (subject, studyProgram) -> subject.setStudyProgram(studyProgram),
                (ID) -> facultyFeignClient.getStudyProgram(ID));
        map(
                subjects,
                (subject) -> subject.getProfessor(),
                (subject, professor) -> subject.setProfessor(professor),
                (ID) -> facultyFeignClient.getTeacher(ID));
        map(
                subjects,
                (subject) -> subject.getAssistant(),
                (subject, assistant) -> subject.setAssistant(assistant),
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjects;
    }
}
