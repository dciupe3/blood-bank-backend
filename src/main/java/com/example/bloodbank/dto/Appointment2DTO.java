package com.example.bloodbank.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class Appointment2DTO {
    private Long id;
    private String donorName;
    private String bloodType;
    private String locationName;
    private String locationAddress;
    private Date date;
}
