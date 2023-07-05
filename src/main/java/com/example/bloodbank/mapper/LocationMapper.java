package com.example.bloodbank.mapper;

import com.example.bloodbank.dto.LocationDTO;
import com.example.bloodbank.entity.Location;

public class LocationMapper {

    public static LocationDTO toDTO(Location location) {
        LocationDTO dto = new LocationDTO();

        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setAddress(location.getAddress());
        dto.setStartOperatingHours(location.getStartOperatingHours());
        dto.setEndOperatingHours(location.getEndOperatingHours());
        dto.setMaxDonations(location.getMaxDonations());
        dto.setPhoto(location.getPhoto());
        dto.setLat(location.getLat());
        dto.setLng(location.getLng());
        return dto;
    }

    public static Location toEntity(LocationDTO dto) {
        Location location = new Location();

        location.setId(dto.getId());
        location.setName(dto.getName());
        location.setAddress(dto.getAddress());
        location.setStartOperatingHours(dto.getStartOperatingHours());
        location.setEndOperatingHours(dto.getEndOperatingHours());
        location.setMaxDonations(dto.getMaxDonations());
        location.setPhoto(dto.getPhoto());
        location.setLng(dto.getLng());
        location.setLat(dto.getLat());
        return location;
    }
}
