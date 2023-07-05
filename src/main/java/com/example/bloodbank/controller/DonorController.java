package com.example.bloodbank.controller;

import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/donor")
public class DonorController {

    private final DonorService donorService;

    @Autowired
    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping("/signup")
    public ResponseEntity<DonorDTO> register(@RequestBody DonorCreateDTO donorCreateDTO) {
        return ResponseEntity.ok(donorService.register(donorCreateDTO));
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable Long id) {
        return donorService.getDonorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
    }
}