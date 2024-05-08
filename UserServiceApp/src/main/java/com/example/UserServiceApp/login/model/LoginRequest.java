package com.example.UserServiceApp.login.model;

public class LoginRequest {
    String UserName;
    String password;

    public LoginRequest() {
    }

    public LoginRequest(String name, String password) {
        this.UserName = name;
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
