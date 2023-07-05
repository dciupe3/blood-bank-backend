package com.example.bloodbank.controller;

import com.example.bloodbank.dto.Appointment2DTO;
import com.example.bloodbank.dto.AppointmentDTO;
import com.example.bloodbank.dto.AppointmentDoctorDTO;
import com.example.bloodbank.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.saveAppointment(appointmentDTO));
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<Appointment2DTO>> getAppointmentsForDonor(@PathVariable Long donorId) {
        List<Appointment2DTO> appointments = appointmentService.getAppointmentsForDonor(donorId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Appointment2DTO>> getAppointmentsForLocation(@PathVariable Long locationId) {
        List<Appointment2DTO> appointments = appointmentService.getAppointmentsForLocation(locationId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentDoctorDTO>> getAppointmentsForDoctor(@PathVariable Long doctorId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        List<AppointmentDoctorDTO> appointments = appointmentService.getAppointmentsForDoctor(doctorId, page, size);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/doctor/{doctorId}/{date}")
    public ResponseEntity<List<AppointmentDoctorDTO>> getAppointmentsForDoctorOnDate(@PathVariable Long doctorId, @PathVariable String date) {
        List<AppointmentDoctorDTO> appointments = appointmentService.getAppointmentsForDoctorOnDate(doctorId, date);
        return ResponseEntity.ok(appointments);
    }

}

