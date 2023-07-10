package com.microservices.example.UserMicroservicedemo.exception;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException()
    {
        super("Resource not found");
    }
}
