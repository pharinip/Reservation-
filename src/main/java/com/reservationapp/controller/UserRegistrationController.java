package com.reservationapp.controller;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.service.UserService;
import com.reservationapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePicture") MultipartFile profilePicture
            ){

        try{
            UserRegistration userRegistration=new UserRegistration();
            userRegistration.setName(name);
            userRegistration.setEmail(email);
            userRegistration.setPassword(password);
            userRegistration.setProfilePicture(profilePicture.getBytes());

            userServiceImpl.createUser(userRegistration);


        }catch(Exception e){
            e.printStackTrace();

        }

        return "done";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistrationDto> getUser(@PathVariable long id){
        UserRegistrationDto userRegistrationDto =userServiceImpl.getUser(id);
        return new ResponseEntity<>(userRegistrationDto, HttpStatus.OK);
    }

}
