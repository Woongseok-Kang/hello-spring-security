package kr.ac.ssu.hellospringsecurity.service;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import kr.ac.ssu.hellospringsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void joinCustomer(Customer customer) {
        String username = customer.getUsername();
        String password = customer.getPassword();
        if (username == null || password == null) {
            throw new RuntimeException("username or password cannot be empty.");
        }

        customerRepository.insertCustomer(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
}
