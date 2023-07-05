package com.example.bloodbank.service.impl;

import com.example.bloodbank.dto.TokenDTO;
import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.entity.Token;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.UserRepository;
import com.example.bloodbank.service.TokenService;
import com.example.bloodbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TokenServiceImpl tokenService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TokenServiceImpl tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @Override
    public Map<String, Object> login(UserDTO userDTO) {
        User user = userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if (user != null) {
            Token token = tokenService.generateToken(user);
            Map<String, Object> response = new HashMap<>();
            response.put("token", token.getToken());
            response.put("userType", token.getUserType());
            response.put("userId", token.getUserId());
            return response;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Override
    public void logout(TokenDTO tokenDTO) {
        tokenService.invalidateToken(tokenDTO.getToken());
    }
}
