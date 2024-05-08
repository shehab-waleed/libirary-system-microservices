package com.example.UserServiceApp.repository;

import com.example.UserServiceApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User findByUserNameAndPassword(String username, String password);


}
