package com.reservationapp;


import lombok.Data;

@Data
public class A {


    private String name;

    private String city;



    public A(String name, String city) {
        this.name = name;
        this.city = city;

    }
}
