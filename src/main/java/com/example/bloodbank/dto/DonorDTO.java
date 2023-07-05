package com.example.bloodbank.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DonorDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String bloodType;
    private String email;
    private String phoneNumber;
}