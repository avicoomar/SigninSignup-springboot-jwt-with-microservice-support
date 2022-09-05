package com.myc.user_service;

import com.myc.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {
    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
