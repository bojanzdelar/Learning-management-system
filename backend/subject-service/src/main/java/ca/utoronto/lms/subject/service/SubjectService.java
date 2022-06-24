package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.shared.service.ExtendedService;
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
                SubjectDTO::getStudyProgram,
                SubjectDTO::setStudyProgram,
                (ID) -> facultyFeignClient.getStudyProgram(ID));
        map(
                subjects,
                SubjectDTO::getProfessor,
                SubjectDTO::setProfessor,
                (ID) -> facultyFeignClient.getTeacher(ID));
        map(
                subjects,
                SubjectDTO::getAssistant,
                SubjectDTO::setAssistant,
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjects;
    }
}
