package com.example.bloodbank.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String location;
    private String cnp;
    private String email;
    private String phoneNumber;
}