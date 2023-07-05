package com.example.bloodbank.mapper;

import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.entity.Donor;
import org.springframework.stereotype.Component;

@Component
public class DonorMapper {

    public DonorDTO toDto(Donor donor) {
        DonorDTO donorDTO = new DonorDTO();
        donorDTO.setId(donor.getId());
        donorDTO.setUsername(donor.getUsername());
        donorDTO.setFirstName(donor.getFirstName());
        donorDTO.setLastName(donor.getLastName());
        donorDTO.setBloodType(donor.getBloodType());
        donorDTO.setPhoneNumber(donor.getPhoneNumber());
        donorDTO.setEmail(donor.getEmail());

        return donorDTO;
    }

    public Donor toEntity(DonorCreateDTO donorCreateDTO) {
        Donor donor = new Donor();
        donor.setUsername(donorCreateDTO.getUsername());
        donor.setPassword(donorCreateDTO.getPassword());
        donor.setFirstName(donorCreateDTO.getFirstName());
        donor.setLastName(donorCreateDTO.getLastName());
        donor.setBloodType(donorCreateDTO.getBloodType());
        donor.setEmail(donorCreateDTO.getEmail());
        donor.setPhoneNumber(donorCreateDTO.getPhoneNumber());

        return donor;
    }
}
