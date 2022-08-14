package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.CountryDTO;
import ca.utoronto.lms.faculty.model.Country;
import ca.utoronto.lms.faculty.service.CountryService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController extends BaseController<Country, CountryDTO, Long> {
    private final CountryService service;

    public CountryController(CountryService service) {
        super(service);
        this.service = service;
    }
}
