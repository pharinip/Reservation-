package com.reservationapp.config;

import com.reservationapp.service.UserService;
import com.reservationapp.service.impl.RouteServiceImpl;
import com.reservationapp.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }


    @Bean
    public UserServiceImpl getUserRegistrationImpl(){

        return new UserServiceImpl();

    }

//    @Bean
//    public RouteServiceImpl getRouteServiceImpl(){
//        return  new RouteServiceImpl();
//    }
}
