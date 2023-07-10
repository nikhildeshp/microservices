package com.HotelService.example.HotelServicedemo.controller;

import com.HotelService.example.HotelServicedemo.entity.Hotel;
import com.HotelService.example.HotelServicedemo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasAuthority;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    private HotelService hotelService;
    //create

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
       //@RequestBody will help in deserializing of the httpRequest
        Hotel hotel_1=hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel_1);
    }

    //get single
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
  public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId)
    {
        Hotel getHotel=hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(getHotel);
    }
    //get all

    @GetMapping("/allHotels")
    public ResponseEntity<List<Hotel>> allHotels()
    {
        List<Hotel> allHotels=hotelService.getAllHotels();

        return ResponseEntity.ok(allHotels);
    }
}
