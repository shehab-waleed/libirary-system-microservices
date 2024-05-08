package com.example.UserServiceApp.register.controller;


import com.example.UserServiceApp.models.User;
import com.example.UserServiceApp.register.services.RegisterServices;
import com.example.UserServiceApp.utill.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegisterController {

    @Autowired
    private RegisterServices registerServices;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody User user
    ) {
        if (!registerServices.isUsernameAvailable(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists.");
        }if (!ValidationUtils.isValidEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is not valid.");
        }if (!registerServices.isEmailAvailable(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
        }if (!ValidationUtils.isValidPhoneNumber(user.getPhoneNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone number is not valid");
        }
        registerServices.register(user);
        return ResponseEntity.ok(user);
    }
}
