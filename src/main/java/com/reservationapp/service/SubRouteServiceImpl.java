package com.reservationapp.service;

import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubRouteServiceImpl implements SubRouteService{

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Override
    public SubRoute addSubRoute(SubRoute subRoute) {
        SubRoute savedSubroute = subRouteRepository.save(subRoute);
return savedSubroute;
    }
}
