package com.microservices.example.UserMicroservicedemo.repository;

import com.microservices.example.UserMicroservicedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {
}
