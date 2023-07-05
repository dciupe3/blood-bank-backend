package com.example.bloodbank.service.impl;

import com.example.bloodbank.dto.LocationDTO;
import com.example.bloodbank.entity.Location;
import com.example.bloodbank.mapper.LocationMapper;
import com.example.bloodbank.repository.LocationRepository;
import com.example.bloodbank.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDTO> getLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

}

