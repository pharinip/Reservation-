package com.reservationapp.controller;

import com.reservationapp.entity.Passenger;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.service.impl.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CSVController {

    @Autowired
    private CSVService csvService;

    @Autowired
    private PassengerRepository passengerRepository; // Assuming you have a repository for Passenger entity

    @GetMapping("/generate-csv")
    public void generateCSV(HttpServletResponse response) throws IOException {
        List<Passenger> passengers = passengerRepository.findAll(); // Fetch passengers from database
        csvService.generateCSV(passengers, response);
    }
}

