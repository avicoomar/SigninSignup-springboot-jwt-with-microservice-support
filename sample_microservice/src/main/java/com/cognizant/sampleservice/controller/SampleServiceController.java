package com.cognizant.sampleservice.controller;

import com.cognizant.sampleservice.util.IsLegitVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class SampleServiceController {

    @Autowired
    private IsLegitVerifier isLegitVerifier;

    @GetMapping("/sample")
    public String sayHello(@RequestParam String username, HttpServletRequest request){
        if(isLegitVerifier.isUsernameAndTokenLegit(username,request)){
            return "Access to website continued";
        }
        return "ACCESS DENIED";
    }
}
