package com.RatingServicesexample.RatingServicedemo.services;

import com.RatingServicesexample.RatingServicedemo.entity.Rating;

import java.util.List;


public interface RatingService {

    //create rating
     Rating createRating(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();

    // get ratings by userid
    List<Rating> getRatingByUserId(String id);

    //get ratings by HotelId

    List<Rating> getRatingByHotelId(String hotelId);


}
