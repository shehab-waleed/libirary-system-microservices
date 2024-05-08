package com.example.UserServiceApp.services;


import com.example.UserServiceApp.models.User;
import com.example.UserServiceApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetUserService {

    @Autowired
    private UserRepo userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
