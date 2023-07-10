package com.HotelService.example.HotelServicedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
//in userservice we used a payload to return the response, we can use it here also

    @ExceptionHandler(HotelNotFoundException.class)//whenever there is hNFE then this below method will get called
    public ResponseEntity<Map<String,Object>> notFound(HotelNotFoundException hotelNotFoundException)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("success",HttpStatus.NOT_FOUND);
        map.put("message",hotelNotFoundException.getMessage());
        map.put("success",false);

        return ResponseEntity.ok(map);
    }
}
