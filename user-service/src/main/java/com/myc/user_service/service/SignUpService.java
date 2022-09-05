package com.myc.user_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myc.user_service.exception.UserAlreadyExistsException;
import com.myc.user_service.entity.User;
import com.myc.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;

    public Map<String,Object> addUser(User user) {
        ObjectMapper oMapper = new ObjectMapper();
        Map<String,Object> status = oMapper.convertValue(user,Map.class);
        try {
            if (userRepository.existsByUsername(user.getUsername())) {
                status.put("usernameAvailable",false);
                throw new UserAlreadyExistsException();
            }
            userRepository.save(user);
            status.replace("userId", userRepository.findByUsername(user.getUsername()).getUserId());
            status.put("usernameAvailable",true);
            System.out.println("User added");
        }
        catch (UserAlreadyExistsException e){
            System.out.println(e);
        }
        return status;
    }
}
