package com.example.bloodbank.controller;

import com.example.bloodbank.dto.TokenDTO;
import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDTO user) {
        try {
            Map<String, Object> response = userService.login(user);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @PostMapping("/logout")
    public void logout(@RequestBody TokenDTO tokenDTO) {
        userService.logout(tokenDTO);
    }
}

