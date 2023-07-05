package com.example.bloodbank.service.impl;

import com.example.bloodbank.entity.Token;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.TokenRepository;
import com.example.bloodbank.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token generateToken(User user) {
        Token token = new Token();
        token.setUser(user);
        token.setToken(user.getUsername() + "_" + System.currentTimeMillis());
        token.setUserId(user.getId());
        token.setUserType(user.getUserType());
        return tokenRepository.save(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void invalidateToken(String token) {
        Token foundToken = tokenRepository.findByToken(token);
        if (foundToken != null) {
            tokenRepository.delete(foundToken);
        }
    }
}
