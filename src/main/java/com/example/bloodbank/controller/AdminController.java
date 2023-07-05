package com.example.bloodbank.controller;


import com.example.bloodbank.dto.DoctorCreateDTO;
import com.example.bloodbank.dto.DoctorDTO;
import com.example.bloodbank.entity.Admin;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.service.AdminService;
import com.example.bloodbank.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;
    private final DoctorService doctorService;

    @Autowired
    public AdminController(AdminService adminService, DoctorService doctorService){
        this.adminService = adminService;
        this.doctorService = doctorService;
    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorCreateDTO doctorCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.saveDoctor(doctorCreateDTO));
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorCreateDTO doctorCreateDTO) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorCreateDTO));
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }


}
