package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Driver;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.RouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.DriverRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;




    @Autowired
    private ModelMapper modelMapper;
    public BusDto addBus(BusDto busDto) {
        Bus bus=mapToEntity(busDto);

        Driver save = driverRepository.save(busDto.getDriver());
        Bus savedBus = busRepository.save(bus);
        BusDto dto = mapToDto(savedBus);
        return dto;

    }

    Bus mapToEntity(BusDto dto){
        Bus bus=modelMapper.map(dto,Bus.class);
        return bus;

    }

    BusDto mapToDto(Bus bus){
        BusDto dto=modelMapper.map(bus,BusDto.class);
        return dto;
    }


    public Driver getDriver(long driverId) {

        Driver driver = driverRepository.findById(driverId).get();
        return driver;
    }
}
