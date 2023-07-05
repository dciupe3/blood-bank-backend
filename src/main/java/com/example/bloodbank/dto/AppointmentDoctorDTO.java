package com.example.bloodbank.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class AppointmentDoctorDTO {
        private Long id;
        private String donorName;
        private String bloodType;
        private String donorEmail;
        private String donorPhone;
        private String locationName;
        private String locationAddress;
        private Date date;
}
