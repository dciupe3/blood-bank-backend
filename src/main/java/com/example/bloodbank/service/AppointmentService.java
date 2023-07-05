package com.example.bloodbank.service;

import com.example.bloodbank.dto.Appointment2DTO;
import com.example.bloodbank.dto.AppointmentDTO;
import com.example.bloodbank.dto.AppointmentDoctorDTO;

import java.sql.Date;
import java.util.List;

public interface AppointmentService {
    AppointmentDTO saveAppointment(AppointmentDTO appointmentDto);
    List<Date> getAvailableAppointmentDates(Long locationId);
    List<Appointment2DTO> getAppointmentsForDonor(Long donorId);
    List<Appointment2DTO> getAppointmentsForLocation(Long locationId);
    List<AppointmentDoctorDTO> getAppointmentsForDoctor(Long doctorId, int page, int size);
    List<AppointmentDoctorDTO> getAppointmentsForDoctorOnDate(Long doctorId, String date);
}
