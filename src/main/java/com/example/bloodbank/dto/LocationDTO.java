package com.example.bloodbank.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
public class LocationDTO {

    private Long id;
    private String name;
    private String address;
    private String startOperatingHours;
    private String endOperatingHours;
    private int maxDonations;
    private String photo;
    private Double lat;
    private Double lng;
}
