package com.example.bloodbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String cnp;
    private String location;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location loc;


    @Override
    public String getUserType() {
        return "DOCTOR";
    }

}

