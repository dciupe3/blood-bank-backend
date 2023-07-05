package com.example.bloodbank.service;

import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.entity.Donor;

import java.util.List;

public interface DonorService {

    Donor saveDonor(Donor donor);

    DonorDTO register(DonorCreateDTO donorCreateDTO);

    List<Donor> getAllDonors();

    Donor getDonorById(Long id) throws ResourceNotFoundException;

    void deleteDonor(Long id);

}
