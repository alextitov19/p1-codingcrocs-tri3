package com.codingcorcs.demo.NewUser;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewUser {
    @NotNull(message = "username can not be empty")
    @NotBlank(message = "username can not be null")
    @Size(min = 6, max = 15, message = "name must be between 6 and 15 character long")
    private String username;
    @NotNull(message = "password must not be empty")
    private String password;


    public NewUser(){

    }

    public NewUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
