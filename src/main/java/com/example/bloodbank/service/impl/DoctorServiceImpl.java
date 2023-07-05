package com.example.bloodbank.service.impl;

import com.example.bloodbank.dto.DoctorCreateDTO;
import com.example.bloodbank.dto.DoctorDTO;
import com.example.bloodbank.entity.Doctor;
import com.example.bloodbank.entity.Location;
import com.example.bloodbank.mapper.DoctorMapper;
import com.example.bloodbank.repository.DoctorRepository;
import com.example.bloodbank.repository.LocationRepository;
import com.example.bloodbank.service.DoctorService;
import com.example.bloodbank.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final LocationRepository locationRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper, LocationRepository locationRepository){
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public DoctorDTO saveDoctor(DoctorCreateDTO doctorCreateDTO) {
        Location location = locationRepository.findById(doctorCreateDTO.getLocationID())
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", doctorCreateDTO.getLocationID()));
        Doctor doctor = doctorMapper.toEntity(doctorCreateDTO, location);

        return doctorMapper.toDto(doctorRepository.save(doctor));
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctor(Long id) {
        return doctorRepository.findById(id)
                .map(doctorMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
    }

    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor", "id", id);
        }
        doctorRepository.deleteById(id);
    }

    public DoctorDTO updateDoctor(Long id, DoctorCreateDTO doctorCreateDTO) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));

        if(doctorCreateDTO.getFirstName() != null)
            doctor.setFirstName(doctorCreateDTO.getFirstName());
        if(doctorCreateDTO.getLastName() != null)
            doctor.setLastName(doctorCreateDTO.getLastName());
        if(doctorCreateDTO.getCnp() != null)
            doctor.setCnp(doctorCreateDTO.getCnp());
        if(doctorCreateDTO.getEmail() != null)
            doctor.setEmail(doctorCreateDTO.getEmail());
/*        if(doctorCreateDTO.getLocation() != null)
            doctor.setLocation(doctorCreateDTO.getLocation());*/
        if(doctorCreateDTO.getUsername() != null)
            doctor.setUsername(doctorCreateDTO.getUsername());
        if(doctorCreateDTO.getPassword() != null)
            doctor.getPassword();doctorCreateDTO.getPassword();

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDto(updatedDoctor);
    }

    @Override
    public Location getDoctorLocation(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorId));

        return doctor.getLoc();
    }

}
