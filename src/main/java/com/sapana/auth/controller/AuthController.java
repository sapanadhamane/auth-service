package com.sapana.auth.controller;

import com.sapana.auth.dto.RegisterRequest;
import com.sapana.auth.dto.LoginResponse;
import com.sapana.auth.dto.LoginRequest;
import com.sapana.auth.entity.User;
import com.sapana.auth.service.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){
        User user= new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userService.registerUser(user);


    }
    @PostMapping("/login")
    public LoginResponse login( @RequestBody LoginRequest request){
        boolean isValid=userService.loginUser( request.getEmail(),
    request.getPassword());

        if (isValid){
         return new LoginResponse("Login successful");
        }  
        return new LoginResponse("Invalid Credentials");
    }
    
}
