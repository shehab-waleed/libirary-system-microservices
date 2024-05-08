package com.example.UserServiceApp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String userType;//normal
    private int userLimit ;
//    @OneToMany(mappedBy = "user")
//    private List<Book> books;

}