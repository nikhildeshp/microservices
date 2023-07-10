package com.RatingServicesexample.RatingServicedemo.repository;

import com.RatingServicesexample.RatingServicedemo.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface RatingRepo extends MongoRepository<Rating,String> {

    //create methods for getAllRatingsByUserId and getAllRatingsByHotelId

    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);
}
