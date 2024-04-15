package com.reservationapp.entity;

import com.reservationapp.entity.SubRoute;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {

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


    @Column(name="busId", unique = true, nullable = false)
    private long busId;

//    @OneToMany(mappedBy = "route")
//    private List<SubRoute> subRoutes;

}
