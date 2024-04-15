package com.reservationapp.payload;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SubRouteDto {


        private long id;


        private String fromLocation;

        private String toLocation;

        private String fromDate;

        private String toDate;

        private String totalDuration;

        private String fromTime;

        private String toTime;

        private long routeId;

        private long busId;



    }



