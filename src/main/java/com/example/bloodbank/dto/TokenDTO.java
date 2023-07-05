package com.example.bloodbank.dto;

import com.example.bloodbank.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenDTO {
    private  String userType;
    private Long userId;
    private String token;
}
