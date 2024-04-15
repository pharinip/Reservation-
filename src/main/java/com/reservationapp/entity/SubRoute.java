package com.reservationapp.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String fromLocation;

    private String toLocation;

    private String fromDate;

    private String toDate;

    private String totalDuration;

    private String fromTime;

    private String toTime;

    @Column(name="route_id" , nullable=false)
    private long routeId;

    @Column(name="bus_id",nullable = false)
    private long busId;



}

