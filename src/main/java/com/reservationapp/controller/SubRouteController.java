package com.reservationapp.controller;

import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.service.SubRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subroute")
public class SubRouteController {

    @Autowired
    private SubRouteService subRouteService;


    @PostMapping("/addsubroute")
    public ResponseEntity<SubRoute> addSubRoute(@RequestBody SubRoute subRoute){
       SubRoute subRoute1= subRouteService.addSubRoute(subRoute);

       return new ResponseEntity<>(subRoute1, HttpStatus.CREATED);

    }




}
