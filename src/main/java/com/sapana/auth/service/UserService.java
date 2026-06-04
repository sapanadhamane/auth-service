package com.sapana.auth.service;

import com.sapana.auth.entity.User;
import com.sapana.auth.entity.Role;
import com.sapana.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
   @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        user.setActive(true);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public boolean loginUser(String email, String password){

        User user=userRepository.findByEmail(email).orElse(null);
        if(user==null){
            return false;
        }
        return passwordEncoder.matches(password, user.getPassword());
    
    };
    
}
