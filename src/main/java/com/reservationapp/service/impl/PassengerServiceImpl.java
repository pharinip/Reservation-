package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Passenger;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.PassengerService;
import com.reservationapp.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private EmailService emailService;


    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;


    @Override
    public void bookTicket(long busId, long routeId, long subRouteId, Passenger passenger) {
        Optional<Bus> byBusId = busRepository.findById(busId);
        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        boolean subRouteIsPresent = false;

        if (byBusId.isPresent()) {
            busIsPresent = true;
            Bus bus = byBusId.get();

        }

        Optional<Route> byRouteId = routeRepository.findById(routeId);

        if (byRouteId.isPresent()) {
            routeIsPresent = true;
            Route route = byRouteId.get();
        }

        Optional<SubRoute> bySubRouteId = subRouteRepository.findById(subRouteId);

        if (bySubRouteId.isPresent()) {
            subRouteIsPresent = true;
            SubRoute subRoute = bySubRouteId.get();
        }

        if (busIsPresent && routeIsPresent || busIsPresent && subRouteIsPresent) {
            Passenger p = new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setBusId(busId);
            p.setRouteId(routeId);
            p.setSubRouteId(passenger.getSubRouteId());
            p.setFromLocation(passenger.getFromLocation());
            p.setToLocation(passenger.getToLocation());
            Passenger savedPassenger = passengerRepository.save(p);
            try {
                emailService.sendTicketEmail(passenger.getEmail(), "Your Travel Ticket", savedPassenger);

            } catch (Exception e) {
                System.out.println(e);
            }


        }

    }
}
