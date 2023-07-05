package com.example.bloodbank.repository;

import com.example.bloodbank.entity.Token;
import com.example.bloodbank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
    Token findByUser(User user);
}
