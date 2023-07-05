package com.example.bloodbank.service.impl;

import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.mapper.DonorMapper;
import com.example.bloodbank.repository.DonorRepository;
import com.example.bloodbank.service.DonorService;
import com.example.bloodbank.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    private final DonorMapper donorMapper;


    @Autowired
    public DonorServiceImpl(DonorRepository donorRepository, DonorMapper donorMapper) {
        this.donorRepository = donorRepository;
        this.donorMapper = donorMapper;
    }

    @Override
    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public DonorDTO register(DonorCreateDTO donorCreateDTO){
        Donor donor = donorMapper.toEntity(donorCreateDTO);

        return donorMapper.toDto(donorRepository.save(donor));
    }

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donor", "id", id));
    }

    @Override
    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}
