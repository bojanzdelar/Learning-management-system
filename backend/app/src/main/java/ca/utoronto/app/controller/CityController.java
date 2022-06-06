package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.CityDTO;
import ca.utoronto.app.model.City;
import ca.utoronto.app.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityController extends BaseController<City, CityDTO, Long> {
    private final CityService service;

    public CityController(CityService service) {
        super(service);
        this.service = service;
    }
}
