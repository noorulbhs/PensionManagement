package com.fse0.microservice.loginservice.services;

import com.fse0.microservice.loginservice.exceptions.UserNameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UserNameNotFoundException {
        Map<String,String> userDetail = new HashMap<String,String>();
        userDetail.put("admin","Admin123");

        if(userDetail.containsKey(username)){
            return new User(username,userDetail.get(username),new ArrayList<>());
        }
        else{
            throw new UserNameNotFoundException("User Not Found");
        }
    }
}
