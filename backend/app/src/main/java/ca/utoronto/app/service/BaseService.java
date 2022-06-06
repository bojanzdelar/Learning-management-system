package ca.utoronto.app.service;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.PagingAndSortingRepository;
import ca.utoronto.app.mapper.BaseMapper;

import java.util.List;

@AllArgsConstructor
public abstract class BaseService<Model, DTO, ID> {
    private final PagingAndSortingRepository<Model, ID> repository;
    private final BaseMapper<Model, DTO> mapper;

    public List<DTO> findAll() {
        return mapper.toDTO((List<Model>) repository.findAll());
    }

    public DTO findOne(ID id) {
        return mapper.toDTO(repository.findById(id).orElse(null));
    }

    public DTO save(DTO DTO) {
        Model model = mapper.toModel(DTO);
        return mapper.toDTO(repository.save(model));
    }

    public boolean delete(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
