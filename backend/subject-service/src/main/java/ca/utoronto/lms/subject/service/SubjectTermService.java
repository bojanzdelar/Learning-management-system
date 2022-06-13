package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.subject.dto.SubjectTermDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectTermMapper;
import ca.utoronto.lms.subject.model.SubjectTerm;
import ca.utoronto.lms.subject.repository.SubjectTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectTermService extends ExtendedService<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermRepository repository;
    private final SubjectTermMapper mapper;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectTermService(SubjectTermRepository repository, SubjectTermMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<SubjectTermDTO> mapMissingValues(List<SubjectTermDTO> subjectTerms) {
        map(
                subjectTerms,
                (subjectTerm) -> subjectTerm.getTeacher(),
                (subjectTerm, teacher) -> subjectTerm.setTeacher(teacher),
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjectTerms;
    }
}
