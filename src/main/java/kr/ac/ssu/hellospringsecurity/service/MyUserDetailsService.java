package kr.ac.ssu.hellospringsecurity.service;

import kr.ac.ssu.hellospringsecurity.domain.Customer;
import kr.ac.ssu.hellospringsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findCustomer(username);
        if (customer == null) {
            throw new RuntimeException("user can't find. username: " + username);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        return new User(customer.getUsername(), customer.getPassword(), authorities);
    }
}