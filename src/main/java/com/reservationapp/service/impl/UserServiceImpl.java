package com.reservationapp.service.impl;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.repository.UserRepository;
import com.reservationapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {


    @Autowired
    private UserRepository userRepository;
    public void createUser(UserRegistration userRegistration) {

        userRepository.save(userRegistration);


    }

    public UserRegistrationDto getUser(long id) {
        UserRegistration savedRegistration = userRepository.getById(id);
        UserRegistrationDto dto=new UserRegistrationDto();
        dto.setId(savedRegistration.getId());
        dto.setName(savedRegistration.getName());
        dto.setEmail(savedRegistration.getEmail());
        dto.setPassword(savedRegistration.getPassword());
        dto.setProfilePicture(savedRegistration.getProfilePicture());

        return dto;
    }
}
