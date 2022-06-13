package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.subject.dto.SubjectMaterialDTO;
import ca.utoronto.lms.subject.feign.FacultyFeignClient;
import ca.utoronto.lms.subject.mapper.SubjectMaterialMapper;
import ca.utoronto.lms.subject.model.SubjectMaterial;
import ca.utoronto.lms.subject.repository.SubjectMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectMaterialService
        extends ExtendedService<SubjectMaterial, SubjectMaterialDTO, Long> {
    private final SubjectMaterialRepository repository;
    private final SubjectMaterialMapper mapper;

    @Autowired private FacultyFeignClient facultyFeignClient;

    public SubjectMaterialService(
            SubjectMaterialRepository repository, SubjectMaterialMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<SubjectMaterialDTO> mapMissingValues(List<SubjectMaterialDTO> subjectMaterials) {
        map(
                subjectMaterials,
                (subjectMaterial) -> subjectMaterial.getTeacher(),
                (subjectMaterial, teacher) -> subjectMaterial.setTeacher(teacher),
                (ID) -> facultyFeignClient.getTeacher(ID));

        return subjectMaterials;
    }
}
