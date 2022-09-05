package com.cognizant.sampleservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Component
public class IsLegitVerifier {

    @Autowired
    private RestTemplate restTemplate;

    public boolean isUsernameAndTokenLegit(String username, HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = header.substring(7);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Boolean> response = this.restTemplate.exchange("http://localhost:9001/isLegit?username="+username, HttpMethod.GET, requestEntity, Boolean.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
