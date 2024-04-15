package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusRouteDto {

    private long id;

    private String fromLocation;

    private String toLocation;

    private String fromDate;

    private String toDate;

    private String totalDuration;

    private String fromTime;

    private String toTime;

    private Long busId;

    private String busNumber;

    private String busType;

    private double price;

    private int totalSeats;

    private int availableSeats;
}
