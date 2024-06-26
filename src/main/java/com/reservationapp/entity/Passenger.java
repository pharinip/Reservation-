package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private long mobile;

    private String fromLocation;

    private String toLocation;

    @Column(name="bus_id",unique = true)
    private  long busId;

    @Column(name="route_id",unique = true)
    private long routeId;

    @Column(name="sub_route_id",unique = true)
    private long subRouteId;

}
