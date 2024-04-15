package com.reservationapp.payload;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.SubRoute;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {


        private long id;

        private String fromLocation;

        private String toLocation;

        private String fromDate;

        private String toDate;

        private String totalDuration;

        private String fromTime;

        private String toTime;

        private long busId;


    }


