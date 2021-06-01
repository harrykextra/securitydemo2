package com.harryman.securitydemo2.controller;

import com.harryman.securitydemo2.data.UserDto;
import com.harryman.securitydemo2.data.exception.RegistrationException;
import com.harryman.securitydemo2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws RegistrationException{
        try {
            userServiceImpl.register(userDto);
            return ResponseEntity.ok().build();
        }catch (RegistrationException e){
            return ResponseEntity.badRequest().body("Email already exists");
        }
    }
}
