package com.HotelService.example.HotelServicedemo.exception;

import com.HotelService.example.HotelServicedemo.repository.HotelRepository;

public class HotelNotFoundException extends RuntimeException{

   public  HotelNotFoundException()
    {
        super("Hotel Not FOund");
    }
}
