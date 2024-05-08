package com.example.UserServiceApp.login.services;



import com.example.UserServiceApp.models.User;
import com.example.UserServiceApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

    @Autowired
    private UserRepo repo;


    public User login(String userName, String password) {
        return repo.findByUserNameAndPassword(userName, password);
    }


}
