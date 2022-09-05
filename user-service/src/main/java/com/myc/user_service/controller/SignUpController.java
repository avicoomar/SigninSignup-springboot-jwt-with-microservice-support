package com.myc.user_service.controller;

import com.myc.user_service.entity.User;
import com.myc.user_service.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @PostMapping("/addUser")
    public Map<String,Object> addUser(@RequestBody User user){
        return signUpService.addUser(user);
    }
}
