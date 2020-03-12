package kr.ac.ssu.hellospringsecurity.service;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import kr.ac.ssu.hellospringsecurity.repository.InMemoryDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final InMemoryDatabase inMemoryDatabase;

    public void joinCustomer(Customer customer) {
        String username = customer.getUsername();
        String password = customer.getPassword();
        if (username == null || password == null) {
            throw new RuntimeException("username or password cannot be empty.");
        }

        inMemoryDatabase.insertCustomer(customer);
    }

    public Set<Customer> getAllCustomer() {
        return inMemoryDatabase.getAllCustomer();
    }
}
