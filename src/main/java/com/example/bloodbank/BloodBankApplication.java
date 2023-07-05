package com.example.bloodbank;

import com.example.bloodbank.controller.AdminController;
import com.example.bloodbank.controller.DonorController;
import com.example.bloodbank.controller.LocationController;
import com.example.bloodbank.controller.UserController;
import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.entity.Admin;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.entity.Location;
import com.example.bloodbank.repository.AdminRepository;
import com.example.bloodbank.repository.LocationRepository;
import com.example.bloodbank.repository.TokenRepository;
import com.example.bloodbank.repository.UserRepository;
import com.example.bloodbank.service.*;
import com.example.bloodbank.service.impl.AdminServiceImpl;
import com.example.bloodbank.service.impl.DonorServiceImpl;
import com.example.bloodbank.service.impl.TokenServiceImpl;
import com.example.bloodbank.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AdminServiceImpl adminService, DoctorService doctorService) {
		return (args) -> {
			/*DonorController donorController = new DonorController(donorService);
			DonorCreateDTO d = new DonorCreateDTO();
			d.setUsername("us");
			d.setEmail("a@a.c");
			d.setBloodType("B");
			d.setPassword("123");
			d.setPhoneNumber("007");
			donorController.register(d);

*/
			Admin admin = new Admin();
			admin.setPassword("admin");
			admin.setUsername("admin");
			AdminController adminController = new AdminController(adminService, doctorService);
			adminService.saveAdmin(admin);
		};
	}

	@Bean
	public CommandLineRunner initLocations(LocationRepository locationRepository) {
		return (args) -> {
			addLocationIfNotExists(locationRepository, "Centrul Regina Maria", "123 Main Street", "10:00", "16:00", 3, "https://cdn-bclkh.nitrocdn.com/bDwrEnpCkesQjiaYFlzXOvguluYtHzzL/assets/images/optimized/rev-429a526/wp-content/uploads/2019/10/goodwill-houston-location-img.jpg", 46.771378892780525, 23.604860993051147);
			addLocationIfNotExists(locationRepository, "Centrul de Recoltare Nr 16", "456 Oak Avenue", "09:00", "17:00", 20, "https://www.goodwill.ab.ca/wp-content/uploads/2021/05/Meadows-Donation-centre-small-1024x683.jpg");
			addLocationIfNotExists(locationRepository, "Centrul de Recoltare Nr 18", "789 Pine Road", "08:00", "18:00", 15, "https://www.blueroutemall.co.za/storage/app/uploads/public/60f/e97/caa/thumb_1123_571_384_0_0_exact_no_up.jpg");
			addLocationIfNotExists(locationRepository, "Centrul de Recoltare Nr 21", "111 Elm Street", "07:00", "19:00", 100, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeepowHGXvB5Mn5kVJkXr253vaQkE42vQ5HQ&usqp=CAU");
		};
	}

	private void addLocationIfNotExists(LocationRepository locationRepository, String name, String address, String startOperatingHours, String endOperatingHours, int maxDonations, String photo) {
		Optional<Location> locationOptional = locationRepository.findByName(name);

		if (locationOptional.isEmpty()) {
			Location location = new Location();
			location.setName(name);
			location.setAddress(address);
			location.setStartOperatingHours(startOperatingHours);
			location.setEndOperatingHours(endOperatingHours);
			location.setMaxDonations(maxDonations);
			location.setPhoto(photo);
			locationRepository.save(location);
		}
	}

	private void addLocationIfNotExists(LocationRepository locationRepository, String name, String address, String startOperatingHours, String endOperatingHours, int maxDonations, String photo, Double lat, Double lng) {
		Optional<Location> locationOptional = locationRepository.findByName(name);

		if (locationOptional.isEmpty()) {
			Location location = new Location();
			location.setName(name);
			location.setAddress(address);
			location.setStartOperatingHours(startOperatingHours);
			location.setEndOperatingHours(endOperatingHours);
			location.setMaxDonations(maxDonations);
			location.setPhoto(photo);
			location.setLat(lat);
			location.setLng(lng);
			locationRepository.save(location);
		}
	}



}
