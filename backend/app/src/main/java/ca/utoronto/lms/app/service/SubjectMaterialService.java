package ca.utoronto.lms.app.service;

import ca.utoronto.lms.app.dto.SubjectMaterialDTO;
import ca.utoronto.lms.app.mapper.SubjectMaterialMapper;
import ca.utoronto.lms.app.model.SubjectMaterial;
import ca.utoronto.lms.app.repository.SubjectMaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectMaterialService extends BaseService<SubjectMaterial, SubjectMaterialDTO, Long> {
    private final SubjectMaterialRepository repository;
    private final SubjectMaterialMapper mapper;

    public SubjectMaterialService(
            SubjectMaterialRepository repository, SubjectMaterialMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
