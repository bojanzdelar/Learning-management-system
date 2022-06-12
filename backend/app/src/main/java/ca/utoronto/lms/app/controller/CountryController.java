package ca.utoronto.lms.app.controller;

import ca.utoronto.lms.app.service.CountryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.lms.app.dto.CountryDTO;
import ca.utoronto.lms.app.model.Country;

@RestController
@RequestMapping("/api/country")
public class CountryController extends BaseController<Country, CountryDTO, Long> {
    private final CountryService service;

    public CountryController(CountryService service) {
        super(service);
        this.service = service;
    }
}
