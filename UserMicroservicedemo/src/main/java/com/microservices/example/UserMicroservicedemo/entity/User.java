package com.microservices.example.UserMicroservicedemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "Id")
    private String userId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "AboutUser")
    private String about;


    //the rating variable will be the rating given by the user to a particular hotel
    @Transient
    //transient is used when we do not want to create a column
   private List<Rating> ratings;
}
