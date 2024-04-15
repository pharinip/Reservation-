package com.reservationapp.service;

import com.reservationapp.payload.BusRouteDto;
import com.reservationapp.payload.RouteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RouteService {
    RouteDto addRoute(RouteDto routeDto);

    List<BusRouteDto> getRoutesandBus(String fromLocation, String toLocation, String fromDate);
}
