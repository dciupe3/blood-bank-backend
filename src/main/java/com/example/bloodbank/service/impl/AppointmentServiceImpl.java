package com.example.bloodbank.service.impl;

import com.example.bloodbank.dto.Appointment2DTO;
import com.example.bloodbank.dto.AppointmentDTO;
import com.example.bloodbank.dto.AppointmentDoctorDTO;
import com.example.bloodbank.entity.Appointment;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.entity.Location;
import com.example.bloodbank.mapper.AppointmentMapper;
import com.example.bloodbank.repository.AppointmentRepository;
import com.example.bloodbank.repository.DonorRepository;
import com.example.bloodbank.repository.LocationRepository;
import com.example.bloodbank.service.AppointmentService;
import com.example.bloodbank.service.DoctorService;
import com.example.bloodbank.service.ResourceNotFoundException;
import com.example.bloodbank.util.EmailSender;
import com.example.bloodbank.util.Message;
import com.example.bloodbank.util.MessageSender;
import com.example.bloodbank.util.MessageSenderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentMapper appointmentMapper;

    private final AppointmentRepository appointmentRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private MessageSenderFactory messageSenderFactory;
    @Autowired
    private EmailSender emailSender;

    @Autowired
    public AppointmentServiceImpl(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {

        Donor donor = donorRepository.findById(appointmentDTO.getDonorId())
                .orElseThrow(() -> new ResourceNotFoundException("Donor", "id", appointmentDTO.getDonorId()));
        Location location = locationRepository.findById(appointmentDTO.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", appointmentDTO.getLocationId()) );

        Appointment appointment = appointmentMapper.toEntity(appointmentDTO, location, donor);

        if(appointmentDTO.getChecked()){
            Message message = new Message.Builder()
                    .text("Dear " + appointment.getDonor().getFirstName() + " " + appointment.getDonor().getLastName() + ",\n\n"
                            + "You made an appointment at: " + appointment.getLocation().getName() + ".\n"
                            + "Address: " + appointment.getLocation().getAddress() + ".\n"
                            + "Appointment date: " + appointment.getDate().toString() + ".\n"
                            + "Best regards! \n")
                    .email(appointment.getDonor().getEmail())
                    .number(appointment.getDonor().getPhoneNumber())
                    .build();
            /*List<MessageSender> senders = MessageSenderFactory.createSenders();
            for(MessageSender sender : senders) {
                sender.sendConfirmation(message);
            }*/
            emailSender.sendConfirmation(message);
        }
        return appointmentMapper.toDto(appointmentRepository.save(appointment));
    }

    @Override
    public List<Date> getAvailableAppointmentDates(Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", locationId));

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(12);

        List<Date> availableDates = new ArrayList<>();

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            long existingAppointments = appointmentRepository.countByLocationAndDate(location, Date.valueOf(date));

            if (existingAppointments < location.getMaxDonations()) {
                availableDates.add(Date.valueOf(date));
            }
        }

        return availableDates;
    }

    @Override
    public List<Appointment2DTO> getAppointmentsForDonor(Long donorId) {
        return appointmentRepository.findAllByDonorId(donorId)
                .stream()
                .map(appointmentMapper::toDto2)
                .collect(Collectors.toList());
    }


    public List<Appointment2DTO> getAppointmentsForLocation(Long locationId) {
        return appointmentRepository.findAllByLocationId(locationId)
                .stream()
                .map(appointmentMapper::toDto2)
                .collect(Collectors.toList());
    }


    /*public List<AppointmentDoctorDTO> getAppointmentsForDoctor(Long doctorId) {
        Location location = doctorService.getDoctorLocation(doctorId);
        return appointmentRepository.findAllByLocation(location)
                .stream()
                .map(appointmentMapper::toDtoDoctor)
                .collect(Collectors.toList());
    }*/

    public List<AppointmentDoctorDTO> getAppointmentsForDoctor(Long doctorId, int page, int size) {
        Location location = doctorService.getDoctorLocation(doctorId);

        Pageable pageable = PageRequest.of(page, size);
        return appointmentRepository.findAllByLocation(location, pageable)
                .stream()
                .map(appointmentMapper::toDtoDoctor)
                .collect(Collectors.toList());
    }


    public List<AppointmentDoctorDTO> getAppointmentsForDoctorOnDate(Long doctorId, String date) {
        Location location = doctorService.getDoctorLocation(doctorId);
        return appointmentRepository.findAllByLocationAndDate(location, Date.valueOf(LocalDate.parse(date)))
                .stream()
                .map(appointmentMapper::toDtoDoctor)
                .collect(Collectors.toList());
    }

    @Scheduled(cron = "0 0 0 * * ?", zone="Europe/Bucharest") //midnight
    public void sendNotifications() {
        LocalDate nextDay = LocalDate.now().plusDays(1);
        List<Appointment> appointments = appointmentRepository.findByDate(Date.valueOf(nextDay));

        System.out.println("A venit vremea :))");
        for (Appointment appointment : appointments) {
            Message message = new Message.Builder()
                    .text("Dear " + appointment.getDonor().getFirstName() + " " + appointment.getDonor().getLastName() + ",\n\n"
                            + "You made an appointment at: " + appointment.getLocation().getName() + ".\n"
                            + "Address: " + appointment.getLocation().getAddress() + ".\n"
                            + "Appointment date: " + appointment.getDate().toString() + ".\n"
                            + "Best regards! \n")
                    .email(appointment.getDonor().getEmail())
                    .number(appointment.getDonor().getPhoneNumber())
                    .build();
            emailSender.sendNotification(message);
        }
    }
}
