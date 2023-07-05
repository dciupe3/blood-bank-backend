package com.example.bloodbank.service.impl;

import com.example.bloodbank.entity.Admin;
import com.example.bloodbank.repository.AdminRepository;
import com.example.bloodbank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        if(adminRepository.findByUsername("admin") == null)
            return adminRepository.save(admin);
        return null;
    }
}
