package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.CityDTO;
import ca.utoronto.lms.faculty.model.City;
import ca.utoronto.lms.faculty.service.CityService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController extends BaseController<City, CityDTO, Long> {
    private final CityService service;

    public CityController(CityService service) {
        super(service);
        this.service = service;
    }
}
