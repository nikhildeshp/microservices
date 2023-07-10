package com.microservices.example.UserMicroservicedemo.exception;

import com.microservices.example.UserMicroservicedemo.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)//if we encounter usernotforundexception anywhere the below mehtod will get called
    public ResponseEntity<ApiResponse> handlerResourceException(UserNotFoundException e){

        String message=e.getMessage();
         ApiResponse response=ApiResponse.builder()
                 .success(true)
                 .message(message)
                 .status(HttpStatus.NOT_FOUND)
                 .build();

         return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
