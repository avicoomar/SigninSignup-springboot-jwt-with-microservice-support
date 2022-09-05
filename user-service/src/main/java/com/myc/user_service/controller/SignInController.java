package com.myc.user_service.controller;

import com.myc.user_service.service.CustomUserDetailsService;
import com.myc.user_service.service.SignInService;

import com.myc.user_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class SignInController {

    @Autowired
    private SignInService signInService;

    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private JwtUtil jwtUtil;
/*
    @PostMapping("/isValid")
    public Map<String,Boolean> isValid(@RequestBody User user) {
        return signInService.isValid(user);
    }*/

    //SO THIS METHOD CHECKS IF USERNAME IS SIGNED IN OR NOT
    @GetMapping("/isLegit")
    public boolean isLegit(HttpServletRequest request, HttpServletResponse response, @RequestParam String username){
        String header = request.getHeader("Authorization");
        String token = header.substring(7);
        UserDetails userDetails = service.loadUserByUsername(username);
        if(jwtUtil.validateToken(token,userDetails)){
            return true;
        }
        return false;
    }

}
