package com.microservices.example.UserMicroservicedemo.services;



import com.microservices.example.UserMicroservicedemo.entity.User;

import java.util.List;


public interface UserService {

    //save User
    User save(User user);

    List<User> getAllUser();

    User getUser(String id);

    User deleteById(String id);




}
