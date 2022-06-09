package ca.utoronto.app.controller;

import ca.utoronto.app.dto.BaseDTO;
import ca.utoronto.app.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class BaseController<Model, DTO extends BaseDTO<ID>, ID> {
    private final BaseService<Model, DTO, ID> service;

    @GetMapping("/all")
    public ResponseEntity<List<DTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<DTO>> getAll(Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> get(@PathVariable ID id) {
        DTO DTO = service.findOne(id);
        if (DTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(DTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO DTO) {
        try {
            return new ResponseEntity<>(service.save(DTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO DTO) {
        DTO.setId(id);
        if (service.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            return new ResponseEntity<>(service.save(DTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable ID id) {
        if (!service.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
