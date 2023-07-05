package com.example.bloodbank.controller;

import com.example.bloodbank.dto.LocationDTO;
import com.example.bloodbank.service.AppointmentService;
import com.example.bloodbank.service.impl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationServiceImpl locationService;

    private AppointmentService appointmentService;

    @Autowired
    public LocationController(LocationServiceImpl locationService, AppointmentService appointmentService) {
        this.locationService = locationService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationDTO>> getLocations() {
        List<LocationDTO> locations = locationService.getLocations();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{locationId}/available-dates")
    public ResponseEntity<List<Date>> getAvailableDates(@PathVariable Long locationId) {
        List<Date> availableDates = appointmentService.getAvailableAppointmentDates(locationId);
        return ResponseEntity.ok(availableDates);
    }
}


