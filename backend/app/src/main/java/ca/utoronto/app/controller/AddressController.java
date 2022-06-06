package ca.utoronto.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.utoronto.app.dto.AddressDTO;
import ca.utoronto.app.model.Address;
import ca.utoronto.app.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController extends BaseController<Address, AddressDTO, Long> {
    private final AddressService service;

    public AddressController(AddressService service) {
        super(service);
        this.service = service;
    }
}
