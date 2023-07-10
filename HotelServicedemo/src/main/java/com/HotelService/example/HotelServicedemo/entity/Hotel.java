package com.HotelService.example.HotelServicedemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotels")
public class Hotel {

    @Id
    @Column(name = "hotelId")
    private String hotelId;
    @Column(name = "hotelName")
    private String hotelName;
    @Column(name = "about")
    private String about;

}
