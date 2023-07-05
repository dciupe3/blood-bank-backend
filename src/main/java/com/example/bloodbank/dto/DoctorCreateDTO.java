package com.example.bloodbank.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorCreateDTO {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String cnp;
    private Long locationID;
}
