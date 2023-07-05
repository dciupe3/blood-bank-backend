package com.example.bloodbank.mapper;

import com.example.bloodbank.dto.DonorCreateDTO;
import com.example.bloodbank.dto.DonorDTO;
import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User() {
            @Override
            public String getUserType() {
                return null;
            }
        };

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setId(userDTO.getId());
        return user;
    }
}
