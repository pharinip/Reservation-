package com.reservationapp.controller;

import com.reservationapp.entity.Driver;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.BusRouteDto;
import com.reservationapp.service.RouteService;
import com.reservationapp.service.impl.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusServiceImpl busServiceImpl;

    @Autowired
    private RouteService routeService;


    //http://localhost:8080/api/v1/bus/addbus
    @PostMapping("/addbus")
    public ResponseEntity<BusDto> addBus(@RequestBody BusDto busDto)  {

//        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
//        Date fromDate= formatter.parse(busDto.getFromDate());
//        Date toDate= formatter.parse(busDto.getToDate());

        BusDto dto= busServiceImpl.addBus(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

//    @GetMapping("/getBus")
//    public List<Route> getBus(@RequestBody RouteDto routeDto){
//        List<Route> routes=busServiceImpl.getBus(routeDto);
//
//
//        return routes;
//    }
//http://localhost:8080/api/v1/bus/getDriver?driverId=
    @GetMapping("/getDriver")
    public Driver getDriver(@RequestParam long driverId){
        Driver driver=busServiceImpl.getDriver(driverId);
        return driver;
    }

    @GetMapping("/getbus")
    public ResponseEntity<?> getRoutesandBus(@RequestParam String fromLocation,
                                                       @RequestParam String toLocation,
                                                       @RequestParam String fromDate
                                                    ){

        routeService.getRoutesandBus(fromLocation,toLocation,fromDate);



        return null;





    }



}
