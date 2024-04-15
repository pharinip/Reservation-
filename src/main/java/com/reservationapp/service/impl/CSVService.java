package com.reservationapp.service.impl;

import com.reservationapp.entity.Passenger;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class CSVService {

    public void generateCSV(List<Passenger> passengers, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=passengers.csv");

        PrintWriter writer = response.getWriter();

        // Write CSV header

        writer.println("ID First Name Last Name Email Mobile From Location To Location Bus ID Route ID Sub Route ID");
     //   writer.println("ID,First Name,Last Name,Email,Mobile,From Location,To Location,Bus ID,Route ID,Sub Route ID");

        // Write CSV rows
        for (Passenger passenger : passengers) {
            writer.println(
                    passenger.getId() + "," +
                            passenger.getFirstName() + "," +
                            passenger.getLastName() + "," +
                            passenger.getEmail() + "," +
                            passenger.getMobile() + "," +
                            passenger.getFromLocation() + "," +
                            passenger.getToLocation() + "," +
                            passenger.getBusId() + "," +
                            passenger.getRouteId() + "," +
                            passenger.getSubRouteId()
            );
        }

        writer.flush();
    }
}

