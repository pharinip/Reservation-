package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.exception.ResourceNotFoundException;
import com.reservationapp.payload.BusRouteDto;
import com.reservationapp.payload.RouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Override
    public RouteDto addRoute(RouteDto routeDto) {
        Bus bus = busRepository.findById(routeDto.getBusId()).orElseThrow(

                () -> new ResourceNotFoundException("Bus not Added with the id"+routeDto.getBusId())
        );

        Optional<Route> byId = routeRepository.findById(routeDto.getBusId());

        if(byId.isPresent()){

            throw new ResourceNotFoundException("Route is already saved for the given busId"+ routeDto.getBusId());
        }else {

           Route route1= mapToEntity(routeDto);
            Route savedRoute = routeRepository.save(route1);
            RouteDto dto = mapToDto(savedRoute);
            return dto;
        }



    }

    @Override
    public List<BusRouteDto> getRoutesandBus(String fromLocation, String toLocation, String fromDate) {
        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<BusRouteDto > buses=new ArrayList<>();


if(routes!=null) {
    for (Route route : routes) {
        Bus bus = busRepository.findById(route.getBusId()).get();
        BusRouteDto busRouteDto = mapToBusRouteDto(bus, route);
        buses.add(busRouteDto);

    }
    return buses;
}
        if(subRoutes!=null) {
            for (SubRoute subRoute : subRoutes) {
                Bus bus = busRepository.findById(subRoute.getBusId()).get();
                BusRouteDto busRouteDto = mapToBusSubRouteDto(bus, subRoute);
                buses.add(busRouteDto);
                return buses;
            }

        }

return null;
    }

    Route mapToEntity(RouteDto routeDto){
        Route route=modelMapper.map(routeDto,Route.class);
        return route;

    }
    RouteDto mapToDto(Route route){
        RouteDto routeDto=modelMapper.map(route, RouteDto.class);
        return routeDto;
    }

    BusRouteDto mapToBusRouteDto(Bus bus,Route route){

        BusRouteDto dto=new BusRouteDto();
        dto.setBusId(bus.getBusId());
        dto.setBusNumber(bus.getBusNumber());
        dto.setBusType(bus.getBusType());
        dto.setPrice(bus.getPrice());
        dto.setAvailableSeats(bus.getAvailableSeats());
        dto.setTotalSeats(bus.getTotalSeats());
        dto.setFromLocation(route.getFromLocation());
        dto.setToLocation(route.getToLocation());
        dto.setFromDate(route.getFromDate());
        dto.setToDate(route.getToDate());
        dto.setToTime(route.getToTime());
        dto.setTotalDuration(route.getTotalDuration());
        dto.setId(route.getId());

        return dto;
    }

    BusRouteDto mapToBusSubRouteDto(Bus bus,SubRoute route){

        BusRouteDto dto=new BusRouteDto();
        dto.setBusId(bus.getBusId());
        dto.setBusNumber(bus.getBusNumber());
        dto.setBusType(bus.getBusType());
        dto.setPrice(bus.getPrice());
        dto.setAvailableSeats(bus.getAvailableSeats());
        dto.setTotalSeats(bus.getTotalSeats());
        dto.setFromLocation(route.getFromLocation());
        dto.setToLocation(route.getToLocation());
        dto.setFromDate(route.getFromDate());
        dto.setToDate(route.getToDate());
        dto.setToTime(route.getToTime());
        dto.setTotalDuration(route.getTotalDuration());
        dto.setId(route.getId());

        return dto;
    }

}
