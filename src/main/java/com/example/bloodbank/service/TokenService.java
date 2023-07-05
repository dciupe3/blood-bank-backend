package com.example.bloodbank.service;

import com.example.bloodbank.entity.Token;
import com.example.bloodbank.entity.User;

public interface TokenService {

    public Token generateToken(User user);
    public Token findByToken(String token);
    public void invalidateToken(String token);
}
