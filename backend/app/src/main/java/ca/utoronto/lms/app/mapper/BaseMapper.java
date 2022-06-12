package ca.utoronto.lms.app.mapper;

import java.util.List;

public interface BaseMapper<Model, DTO> {
    DTO toDTO(Model model);

    Model toModel(DTO DTO);

    List<DTO> toDTO(List<Model> model);

    List<Model> toModel(List<DTO> DTO);
}