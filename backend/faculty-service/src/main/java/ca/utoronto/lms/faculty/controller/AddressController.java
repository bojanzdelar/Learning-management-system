package ca.utoronto.lms.faculty.controller;

import ca.utoronto.lms.faculty.dto.AddressDTO;
import ca.utoronto.lms.faculty.model.Address;
import ca.utoronto.lms.faculty.service.AddressService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController<Address, AddressDTO, Long> {
    private final AddressService service;

    public AddressController(AddressService service) {
        super(service);
        this.service = service;
    }
}
