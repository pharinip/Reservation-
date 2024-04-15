package com.reservationapp.payload;

import com.reservationapp.entity.Route;

import com.reservationapp.entity.Driver;
import com.reservationapp.entity.SubRoute;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {

    private Long busId;

    private String busNumber;

    private String busType;

    private double price;

    private int totalSeats;

    private int availableSeats;

    private Driver driver;


}
