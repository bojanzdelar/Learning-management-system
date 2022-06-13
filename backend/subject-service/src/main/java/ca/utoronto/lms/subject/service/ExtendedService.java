package ca.utoronto.lms.subject.service;

import ca.utoronto.lms.subject.dto.BaseDTO;
import ca.utoronto.lms.subject.mapper.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    protected Set<ID> getID(List<DTO> list, Getter<DTO, ID> getter) {
        return list.stream()
                .filter((el) -> getter.get(el) != null)
                .map((el) -> getter.get(el).getId())
                .collect(Collectors.toSet());
    }

    protected <MissingDTO extends BaseDTO> void replaceID(
            List<DTO> list,
            List<MissingDTO> missingList,
            Getter<DTO, ID> getter,
            Setter<DTO, MissingDTO> setter) {
        list.forEach(
                el -> {
                    setter.set(
                            el,
                            missingList.stream()
                                    .filter((missing) -> getter.get(el).getId() == missing.getId())
                                    .findFirst()
                                    .orElse(null));
                });
    }

    protected <MissingDTO extends BaseDTO> void map(
            List<DTO> list,
            Getter<DTO, ID> getter,
            Setter<DTO, MissingDTO> setter,
            FeignClient<MissingDTO, ID> client) {
        Set<ID> ID = getID(list, getter);
        List<MissingDTO> missingList = client.call(ID);
        if (!missingList.isEmpty()) {
            replaceID(list, missingList, getter, setter);
        }
    }

    protected abstract List<DTO> mapMissingValues(List<DTO> DTO);

    interface FeignClient<DTO, ID> {
        List<DTO> call(Set<ID> ids);
    }

    interface Getter<DTO, ID> {
        BaseDTO<ID> get(DTO DTO);
    }

    interface Setter<DTO, OtherDTO> {
        void set(DTO DTO, OtherDTO val);
    }
}
