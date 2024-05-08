package com.example.UserServiceApp.controller;


import com.example.UserServiceApp.annotations.AuthorizationRequired;
import com.example.UserServiceApp.annotations.UserRoleCheck;
import com.example.UserServiceApp.dtos.ResponseDTO;
import com.example.UserServiceApp.enums.UserRole;
import com.example.UserServiceApp.enums.UserStatus;
import com.example.UserServiceApp.models.User;
import com.example.UserServiceApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UsersActivationController {
    private final UserService userService;

    public UsersActivationController(UserService userService) {
        this.userService = userService;
    }

    @AuthorizationRequired
    @UserRoleCheck(UserRole.LIBRARIAN)
    @PatchMapping("/api/librarian/users/{Id}/approve")
    public ResponseEntity<ResponseDTO> approve(@PathVariable Integer Id) {

        User existingUser = userService.findById(Id);

        if(existingUser == null){
            return ResponseEntity.badRequest()
                    .body(
                            new ResponseDTO(
                                    "User not found.",
                                    HttpStatus.BAD_REQUEST
                            )
                    );
        }

        if(existingUser.getStatus().equals(UserStatus.approved.toString())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(
                            new ResponseDTO(
                                    "User is approved allready.",
                                    HttpStatus.BAD_REQUEST,
                                    new HashMap<String , Object>(){{
                                        put("user", existingUser);
                                    }}
                            )
                    );
        }

        User updatedUser = userService.approve(existingUser);

        return ResponseEntity.ok()
                .body(
                        new ResponseDTO(
                                "Account approved succesfully.",
                                HttpStatus.OK,
                                new HashMap<String , Object>(){{
                                    put("user", updatedUser);
                                }}
                        )
                );
    }

    @AuthorizationRequired
    @UserRoleCheck(UserRole.LIBRARIAN)
    @PatchMapping("/api/librarian/users/{Id}/reject")
    public ResponseEntity<ResponseDTO> reject(@PathVariable Integer Id) {

        User existingUser = userService.findById(Id);

        if(existingUser == null){
            return ResponseEntity.badRequest()
                    .body(
                            new ResponseDTO(
                                    "User not found.",
                                    HttpStatus.BAD_REQUEST
                            )
                    );
        }

        if(existingUser.getStatus().equals(UserStatus.rejected.toString())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(
                            new ResponseDTO(
                                    "User is rejected allready.",
                                    HttpStatus.BAD_REQUEST,
                                    new HashMap<String , Object>(){{
                                        put("user", existingUser);
                                    }}
                            )
                    );
        }

        User updatedUser = userService.reject(existingUser);

        return ResponseEntity.ok()
                .body(
                        new ResponseDTO(
                                "Account rejected succesfully.",
                                HttpStatus.OK,
                                new HashMap<String , Object>(){{
                                    put("user", updatedUser);
                                }}
                        )
                );
    }
}
