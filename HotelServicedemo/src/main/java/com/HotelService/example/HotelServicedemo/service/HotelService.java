package com.HotelService.example.HotelServicedemo.service;


import com.HotelService.example.HotelServicedemo.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {

    //create Hotel
 public Hotel save(Hotel hotel);
    //get hotel by Id
Hotel getHotelById(String id);
    //get all hotel
    List<Hotel> getAllHotels();
}
