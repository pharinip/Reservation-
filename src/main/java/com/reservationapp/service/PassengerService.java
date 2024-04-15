package com.reservationapp.service;

import com.reservationapp.entity.Passenger;

public interface PassengerService {
    void bookTicket(long busId, long routeId, long subRouteId,Passenger passenger);

}
