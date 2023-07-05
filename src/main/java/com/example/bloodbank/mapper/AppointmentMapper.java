package com.example.bloodbank.mapper;

import com.example.bloodbank.dto.Appointment2DTO;
import com.example.bloodbank.dto.AppointmentDTO;
import com.example.bloodbank.dto.AppointmentDoctorDTO;
import com.example.bloodbank.entity.Appointment;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.entity.Location;
import com.example.bloodbank.service.LocationService;
import com.example.bloodbank.service.impl.LocationServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDto(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();

        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setDonorId(appointment.getDonor().getId());
        dto.setLocationId(appointment.getLocation().getId());

        return  dto;
    }

    public Appointment toEntity(AppointmentDTO dto, Location location, Donor donor) {
        Appointment appointment = new Appointment();

        appointment.setDate(dto.getDate());
        appointment.setLocation(location);
        appointment.setDonor(donor);

        return appointment;
    }

    public Appointment2DTO toDto2(Appointment appointment) {
        Appointment2DTO dto = new Appointment2DTO();

        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setDonorName(appointment.getDonor().getLastName() + " " + appointment.getDonor().getFirstName());
        dto.setBloodType(appointment.getDonor().getBloodType());
        dto.setLocationName(appointment.getLocation().getName());
        dto.setLocationAddress(appointment.getLocation().getAddress());

        return dto;
    }

    public AppointmentDoctorDTO toDtoDoctor(Appointment appointment) {
        AppointmentDoctorDTO dto = new AppointmentDoctorDTO();

        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setDonorName(appointment.getDonor().getLastName() + " " + appointment.getDonor().getFirstName());
        dto.setBloodType(appointment.getDonor().getBloodType());
        dto.setLocationName(appointment.getLocation().getName());
        dto.setLocationAddress(appointment.getLocation().getAddress());
        dto.setDonorPhone(appointment.getDonor().getPhoneNumber());
        dto.setDonorEmail(appointment.getDonor().getEmail());
        return dto;
    }
}
