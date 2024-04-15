package com.reservationapp;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class B {


    public static void main(String[] args) {


        List<A>  a= Arrays.asList(
                new A("mike", "chennai"),
                new A("john", "kolar")
        );
        System.out.println(a);


    }
}
