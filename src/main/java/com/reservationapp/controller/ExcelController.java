package com.reservationapp.controller;

import com.reservationapp.entity.Passenger;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.service.impl.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private PassengerRepository passengerRepository; // Assuming you have a repository for Passenger entity

    @GetMapping("/generate-excel")
    public void generateExcel(HttpServletResponse response) throws IOException {
        List<Passenger> passengers = passengerRepository.findAll(); // Fetch passengers from database
        excelService.generateExcel(passengers, response);
    }
}

