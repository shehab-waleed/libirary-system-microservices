package com.example.UserServiceApp.login.controller;


import com.example.UserServiceApp.login.model.LoginRequest;
import com.example.UserServiceApp.login.services.LoginServices;
import com.example.UserServiceApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginServices loginServices;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest
    ) {
        User user = loginServices.login(loginRequest.getUserName(), loginRequest.getPassword());
        if (user != null) {

            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password. Please try again.");
        }

    }


}
