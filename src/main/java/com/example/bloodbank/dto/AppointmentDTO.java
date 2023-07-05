package com.example.bloodbank.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class AppointmentDTO {

    private Long id;

    private Long donorId;

    private Long locationId;

    private Date date;

    private Boolean checked;
}