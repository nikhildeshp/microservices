package com.RatingServicesexample.RatingServicedemo.controller;

import com.RatingServicesexample.RatingServicedemo.entity.Rating;
import com.RatingServicesexample.RatingServicedemo.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    //create the ratings

    @PostMapping("/createRating")
    public ResponseEntity<Rating> createRatings(@RequestBody Rating rating)
    {
        Rating ratings=ratingService.createRating(rating);

        return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
    }

    //get all ratings

    @GetMapping("/all-ratings")
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    //get ratingsByUseriId
    @GetMapping("/ratings-by-user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserid(@PathVariable String userId)
    {
        List<Rating> rating_1=ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(rating_1);
    }

    @GetMapping("/ratings-by-hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
