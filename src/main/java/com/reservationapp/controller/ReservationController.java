package com.reservationapp.controller;


import com.reservationapp.entity.Passenger;
import com.reservationapp.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private PassengerService passengerService;


      @PostMapping("/bookticket")
    public ResponseEntity<Passenger> bookTicket(@RequestParam long busId,
                                                @RequestParam long routeId,
                                                @RequestParam long subRouteId,
                                                @RequestBody Passenger passenger


    ){
        passengerService.bookTicket(busId,routeId,subRouteId,passenger);
        return null;


    }
}
