package com.example.springboot.entity;

public class UserAccount {
    private String username;
    private String password;
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setUserAccount(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public void setPassword(String password){this.username = password;}
    public void setUsername(String username){this.username = username;}
}
