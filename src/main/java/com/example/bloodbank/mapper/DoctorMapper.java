package com.example.bloodbank.mapper;

import com.example.bloodbank.dto.DoctorCreateDTO;
import com.example.bloodbank.dto.DoctorDTO;
import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.entity.Doctor;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorDTO toDto(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setUsername(doctor.getUsername());
        doctorDTO.setFirstName(doctor.getFirstName());
        doctorDTO.setLastName(doctor.getLastName());
        doctorDTO.setCnp(doctor.getCnp());
        doctorDTO.setPhoneNumber(doctor.getPhoneNumber());
        doctorDTO.setEmail(doctor.getEmail());
        doctorDTO.setLocation(doctor.getLocation());

        return doctorDTO;
    }

    public Doctor toEntity(DoctorCreateDTO doctorCreateDTO, Location location) {
        Doctor doctor = new Doctor();
        doctor.setUsername(doctorCreateDTO.getUsername());
        doctor.setPassword(doctorCreateDTO.getPassword());
        doctor.setFirstName(doctorCreateDTO.getFirstName());
        doctor.setLastName(doctorCreateDTO.getLastName());
        doctor.setCnp(doctorCreateDTO.getCnp());
        doctor.setEmail(doctorCreateDTO.getEmail());
        doctor.setPhoneNumber(doctorCreateDTO.getPhoneNumber());
        doctor.setLocation(location.getName());
        doctor.setLoc(location);
        return doctor;
    }
}
