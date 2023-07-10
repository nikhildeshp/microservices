package com.HotelService.example.HotelServicedemo.repository;

import com.HotelService.example.HotelServicedemo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
