package kr.ac.ssu.hellospringsecurity.repository;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
@RequiredArgsConstructor
@Slf4j
public class InMemoryDatabase {
    private Map<String, Customer> customers = new HashMap<>();
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void insertCustomer(Customer customer) {
        String username = customer.getUsername();
        String password = customer.getPassword();

        if (customers.containsKey(username)) {
            throw new RuntimeException("user already exist! : " + username);
        }

        customer.setPassword(bCryptPasswordEncoder.encode(password));

        customers.put(username, customer);
        log.info("Customer has successfully joined: {}", customer);
    }

    public Customer findCustomer(String username) {
        return customers.get(username);
    }

    public Set<Customer> getAllCustomer() {
        return new HashSet<>(customers.values());
    }
}
