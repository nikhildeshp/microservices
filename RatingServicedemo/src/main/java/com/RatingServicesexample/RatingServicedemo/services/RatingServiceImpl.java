package com.RatingServicesexample.RatingServicedemo.services;

import com.RatingServicesexample.RatingServicedemo.entity.Rating;
import com.RatingServicesexample.RatingServicedemo.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;
    @Override

    public Rating createRating(Rating rating) {
        String ratingId= UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
         return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }
//now we do not have predefined method for getRatingByUserID or HotelId ,so we have o create those methods inside the mongoRepository interface
    @Override
    public List<Rating> getRatingByUserId(String id) {

        return ratingRepo.getRatingsByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.getRatingsByHotelId(hotelId);
    }
}
