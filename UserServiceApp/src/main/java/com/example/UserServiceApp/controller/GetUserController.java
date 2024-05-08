package com.example.UserServiceApp.controller;



import com.example.UserServiceApp.models.User;
import com.example.UserServiceApp.services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GetUserController {

    @Autowired
    GetUserService getUserService;

    @GetMapping("/getAllUsers")
    public List<User> getAlUsers(){
        return  getUserService.getAllUsers();
    }

}
