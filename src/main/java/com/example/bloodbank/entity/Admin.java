package com.example.bloodbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("ADMIN")
@Setter
@Getter
public class Admin extends User {

    @Override
    public String getUserType() {
        return "ADMIN";
    }
}
