package com.example.bloodbank.service;

import com.example.bloodbank.dto.TokenDTO;
import com.example.bloodbank.dto.UserDTO;

import java.util.Map;

public interface UserService {

    public Map<String, Object> login(UserDTO userDTO);

    public void logout(TokenDTO token);
}
