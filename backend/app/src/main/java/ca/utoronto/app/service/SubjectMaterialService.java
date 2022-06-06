package ca.utoronto.app.service;

import org.springframework.stereotype.Service;
import ca.utoronto.app.dto.SubjectMaterialDTO;
import ca.utoronto.app.mapper.SubjectMaterialMapper;
import ca.utoronto.app.model.SubjectMaterial;
import ca.utoronto.app.repository.SubjectMaterialRepository;

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
