package com.example.bloodbank.repository;

import com.example.bloodbank.entity.Appointment;
import com.example.bloodbank.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    long countByLocationAndDate(Location location, Date date);
    List<Appointment> findAllByDonorId(Long donorId);
    List<Appointment> findAllByLocationId(Long locationId);
//    List<Appointment> findAllByLocation(Location location);
    List<Appointment> findAllByLocationAndDate(Location location, Date date);
    Page<Appointment> findAllByLocation(Location location, Pageable pageable);
    List<Appointment> findByDate(Date date);
}
