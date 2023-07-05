package com.example.bloodbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "appointments")
@Setter
@Getter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

/*    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;*/

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    
    private Date date;
}