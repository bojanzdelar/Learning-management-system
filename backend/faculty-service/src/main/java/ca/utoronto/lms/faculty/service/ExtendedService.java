package ca.utoronto.lms.faculty.service;

import ca.utoronto.lms.faculty.mapper.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;

public abstract class ExtendedService<Model, DTO, ID> extends BaseService {
    private final PagingAndSortingRepository<Model, ID> repository;
    private final BaseMapper<Model, DTO> mapper;

    public ExtendedService(PagingAndSortingRepository repository, BaseMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<DTO> findAll(Pageable pageable) {
        Page<DTO> DTO = repository.findAll(pageable).map(mapper::toDTO);
        return new PageImpl<>(mapMissingValues(DTO.getContent()), pageable, DTO.getTotalElements());
    }

    @Override
    public List<DTO> findById(Set id) {
        List<DTO> DTO = mapper.toDTO((List<Model>) repository.findAllById(id));
        return mapMissingValues(DTO);
    }

    protected abstract List<DTO> mapMissingValues(List<DTO> DTO);
}
