package com.microservices.example.UserMicroservicedemo.controller;

import com.microservices.example.UserMicroservicedemo.entity.User;
import com.microservices.example.UserMicroservicedemo.services.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @Autowired
  private UserService userService;

    @GetMapping("/allStaff")
    public ResponseEntity<List<User>> getAllStaff()
    {
        List<User> users=userService.getAllUser();
        return ResponseEntity.ok(users);
    }
}
