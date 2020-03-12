package kr.ac.ssu.hellospringsecurity.controller;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import kr.ac.ssu.hellospringsecurity.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api")
@RequiredArgsConstructor
public class PublicApiController {
    private final CustomerService customerService;
// http://localhost:8080/public/api/v1/messages
    @GetMapping("/v1/messages")
    public String getMessage() {
        return "Hello from public API controller";
    }

    // http://localhost:8080/public/api/v1/customers
    @PostMapping("/v1/customers")
    public void joinCustomer(@RequestBody Customer customer) {
        customerService.joinCustomer(customer);
    }
}
