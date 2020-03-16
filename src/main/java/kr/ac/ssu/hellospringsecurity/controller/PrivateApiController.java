package kr.ac.ssu.hellospringsecurity.controller;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import kr.ac.ssu.hellospringsecurity.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/private/api")
@RequiredArgsConstructor
public class PrivateApiController {
    private final CustomerService customerService;

    // http://localhost:8080/private/api/v1/messages
    @GetMapping("/v1/messages")
    public String getMessage() {
        return "Hello from private API controller";
    }

    @GetMapping("/v1/customers")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
}
