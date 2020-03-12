package kr.ac.ssu.hellospringsecurity.domain;

import lombok.Data;

@Data
public class Customer {
    private String username;
    private String password;
    private String mobile;
}
