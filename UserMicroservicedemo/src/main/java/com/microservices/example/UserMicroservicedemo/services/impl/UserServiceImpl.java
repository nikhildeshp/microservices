package com.microservices.example.UserMicroservicedemo.services.impl;

import com.microservices.example.UserMicroservicedemo.entity.Hotel;
import com.microservices.example.UserMicroservicedemo.entity.Rating;
import com.microservices.example.UserMicroservicedemo.entity.User;
import com.microservices.example.UserMicroservicedemo.exception.UserNotFoundException;
import com.microservices.example.UserMicroservicedemo.externalservices.HotelService;
import com.microservices.example.UserMicroservicedemo.repository.UserRepository;
import com.microservices.example.UserMicroservicedemo.services.UserService;
import lombok.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Setter
@Getter
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    private User user;

    @Autowired
    private RestTemplate restTemplate;


//    private Logger logger;
    @Override
    public User save(User user) {
        //it will generate random Unique id
        String randomUID= UUID.randomUUID().toString();
        user.setUserId(randomUID);
        return userRepository.save(user);
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers=userRepository.findAll();
        return allUsers;
    }

    @Autowired
    private HotelService hotelService;
    @Override
    public User getUser(String id) {
        //here we are handling the user not fond exception if the userid given is not present in the db
        //return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        User user =userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        //we have to get the rating also given by the user with a particular userid
        //http://localhost:8083/ratings/ratings-by-user/6f29e568-074f-46cc-a917-155961045e4f
        //Note:to communicate between to services there many api clients such as RestTemplate feign client
        //we will use RestTemplate in this example
        //steps to create:
        //Inject the RestTemplate in service
        //create a @Config class of the RestTemplate (the spring will register the bean class)

       Rating[] ratingByUser= restTemplate.getForObject("http://RATING-SERVICE/ratings/ratings-by-user/" + user.getUserId(), Rating[].class);

       //we need to pass the api url for which we want to fetch the details
        // (in the above example we have used the user url along with the user id)
        // and an object to store the elements ArrayList in this case
        //info(ring>) ratingByUser);

        List<Rating> ratings= Arrays.stream(ratingByUser).toList();

        List<Rating> ratingList=ratings.stream().map(rating->{
            //api call to hotel service to get the hotels
            //http://localhost:8082/hotels/a2bc0591-cbed-457e-9bf5-254c71e72f0f
            System.out.println(rating.getHotelId());
          //  ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);//we replace the localhost hard coding to the service name given in the service registry
            Hotel hotel=hotelService.getHotel(rating.getHotelId());//feign client method
            //set the rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User deleteById(String id) {
        return null;
    }

    }

