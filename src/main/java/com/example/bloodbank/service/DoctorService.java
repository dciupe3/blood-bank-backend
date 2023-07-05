package com.example.bloodbank.service;

import com.example.bloodbank.dto.DoctorCreateDTO;
import com.example.bloodbank.dto.DoctorDTO;
import com.example.bloodbank.entity.Location;

import java.util.List;

public interface DoctorService {
    DoctorDTO saveDoctor(DoctorCreateDTO doctorCreateDTO);
    public List<DoctorDTO> getAllDoctors();
    public DoctorDTO getDoctor(Long id);
    public void deleteDoctor(Long id);
    public DoctorDTO updateDoctor(Long id, DoctorCreateDTO doctorCreateDTO);
    Location getDoctorLocation(Long doctorId);
}
