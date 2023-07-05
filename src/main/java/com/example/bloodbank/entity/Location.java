package com.example.bloodbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "locations")
@Setter
@Getter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Location(){

    }

    private String name;

    private String address;

    private String startOperatingHours;

    private String endOperatingHours;

    private int maxDonations;

    private String photo;

    @OneToMany(mappedBy = "location")
    private List<Appointment> appointments;

    private Double lat;
    private Double lng;

    public Location(String name, String address, String startOperatingHours, String endOperatingHours, int maxDonations, List<Appointment> appointments) {
        this.name = name;
        this.address = address;
        this.startOperatingHours = startOperatingHours;
        this.endOperatingHours = endOperatingHours;
        this.maxDonations = maxDonations;
        this.appointments = appointments;
        this.lat = 0.0;
        this.lng = 0.0;
    }

    public Location(String name, String address, String startOperatingHours, String endOperatingHours, int maxDonations, List<Appointment> appointments, Double lat, Double lng) {
        this.name = name;
        this.address = address;
        this.startOperatingHours = startOperatingHours;
        this.endOperatingHours = endOperatingHours;
        this.maxDonations = maxDonations;
        this.appointments = appointments;
        this.lat = lat;
        this.lng = lng;
    }

}