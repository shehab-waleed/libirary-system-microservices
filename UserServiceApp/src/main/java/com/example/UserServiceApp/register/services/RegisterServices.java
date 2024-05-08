package com.example.UserServiceApp.register.services;


import com.example.UserServiceApp.models.User;
import com.example.UserServiceApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices {

    @Autowired
    private UserRepo userRepository;



    public void register(User user) {

        userRepository.save(user);
    }

    public boolean isUsernameAvailable(String username) {
        return userRepository.findByUsername(username) == null;
    }

    public boolean isEmailAvailable(String email) {
        return userRepository.findByEmail(email) == null;
    }


}
