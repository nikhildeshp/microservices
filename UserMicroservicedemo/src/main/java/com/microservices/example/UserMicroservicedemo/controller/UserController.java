package com.microservices.example.UserMicroservicedemo.controller;

import com.microservices.example.UserMicroservicedemo.entity.User;
import com.microservices.example.UserMicroservicedemo.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;
    //create user

    @Autowired
    UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user)
    {
        User user1=userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //response entity is the class which represents the HTTP response like status,code etc

    //single user get
int retry =1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelRetry",fallbackMethod = "ratingHotelFallback")

    public ResponseEntity<User> getUserById(@PathVariable String userId)
    {
        System.out.println("retrying "+ retry);
        retry++;
         User user=userService.getUser(userId);
         return ResponseEntity.ok(user);

    }
        public ResponseEntity<User> ratingHotelFallback(String id,Exception e)
    {
       // System.out.println("fallBack method is executed because the service is down"+ e.getMessage());

        User user=User.builder().userId(id).email("dummy@dummy.com").name("dummyUser").about("the service is down").build();
        return ResponseEntity.ok(user);
    }
    @GetMapping ("allUsers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers=userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }
}


//fiegn client is a declarative HTTP web client developed by Netflix