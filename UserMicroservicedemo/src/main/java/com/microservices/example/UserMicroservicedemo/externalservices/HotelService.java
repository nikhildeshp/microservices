package com.microservices.example.UserMicroservicedemo.externalservices;

import com.microservices.example.UserMicroservicedemo.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
//steps to use feign client

//create an interface service of the service for which we need to communicate
//annotate it with @Feign Client
//then in the userService call the method