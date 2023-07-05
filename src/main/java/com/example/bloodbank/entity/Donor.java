package com.example.bloodbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("DONOR")
@Setter
@Getter
public class Donor extends User {

    private String firstName;
    private String lastName;
    private String bloodType;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "donor")
    private List<Appointment> appointments;

    @Override
    public String getUserType() {
        return "DONOR";
    }
}