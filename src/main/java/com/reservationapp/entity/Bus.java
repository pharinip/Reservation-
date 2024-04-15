package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @Column(name="bus_number" ,nullable = false, unique = true)
    private String busNumber;

    private String busType;

    private double price;

    private int totalSeats;

    private int availableSeats;

    @OneToOne
    @JoinColumn(name="driver_id")
    private Driver driver;

}

