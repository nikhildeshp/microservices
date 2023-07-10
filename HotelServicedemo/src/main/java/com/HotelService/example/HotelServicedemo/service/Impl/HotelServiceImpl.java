package com.HotelService.example.HotelServicedemo.service.Impl;

import com.HotelService.example.HotelServicedemo.entity.Hotel;
import com.HotelService.example.HotelServicedemo.exception.HotelNotFoundException;
import com.HotelService.example.HotelServicedemo.repository.HotelRepository;
import com.HotelService.example.HotelServicedemo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel save(Hotel hotel) {
        //it will generate UU id each time a new hotel is created
        String Uid= UUID.randomUUID().toString();
        hotel.setHotelId(Uid);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {


        //handle invalid user id exception
        return hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException());
    }

    @Override
    public List<Hotel> getAllHotels() {
        return null;
    }
}
