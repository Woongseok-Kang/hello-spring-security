package kr.ac.ssu.hellospringsecurity.repository;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomerRepository {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MongoTemplate mongoTemplate;

    public void insertCustomer(Customer customer) {
        String username = customer.getUsername();
        String password = customer.getPassword();

        if (mongoTemplate.exists(Query.query(Criteria.where("username").is(username)), Customer.class)) {
            throw new RuntimeException("user already exist! : " + username);
        }

        customer.setPassword(bCryptPasswordEncoder.encode(password));

        mongoTemplate.insert(customer, "customer");
        log.info("Customer has successfully joined: {}", customer);
    }

    public Customer findCustomer(String username) {
        return mongoTemplate.findOne(Query.query(Criteria.where("username").is(username)), Customer.class);
    }

    public List<Customer> getAllCustomer() {
        return mongoTemplate.findAll(Customer.class);
    }
}
