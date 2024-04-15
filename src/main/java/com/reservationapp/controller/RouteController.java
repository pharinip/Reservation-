package com.reservationapp.controller;

import com.reservationapp.payload.RouteDto;
import com.reservationapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;



//    public RouteController(RouteService routeService) {
//        this.routeService = routeService;
//    }

    @PostMapping("/addroute")
    public ResponseEntity<RouteDto> addRoute(@RequestBody RouteDto routeDto){
        RouteDto dto=routeService.addRoute(routeDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }



}
