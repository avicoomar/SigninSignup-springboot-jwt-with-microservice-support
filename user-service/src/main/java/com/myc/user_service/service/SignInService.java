package com.myc.user_service.service;

import com.myc.user_service.exception.UserDoesNotExistException;
import com.myc.user_service.entity.User;
import com.myc.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignInService {

    @Autowired
    private UserRepository userRepository;

    public Map<String,Boolean> isValid(User user) {
        Map<String,Boolean> status = new HashMap<>();
        try {
            if (userRepository.findByUsername(user.getUsername()) == null)  {
                status.put("userExists",false);
                throw new UserDoesNotExistException();
            }
            status.put("userExists",true);
            boolean isValidUser = userRepository.findByUsername(user.getUsername()).getPassword().equals(user.getPassword());
            status.put("loginStatus", isValidUser);
        }
        catch (UserDoesNotExistException e){
            System.out.println(e);
        }
        return status;
    }
}
