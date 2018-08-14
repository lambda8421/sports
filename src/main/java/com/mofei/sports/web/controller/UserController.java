package com.mofei.sports.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public void register(){

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public LoginForm login( @RequestBody LoginForm loginForm){


        System.out.println(loginForm.toString());
        return loginForm;
    }
}

class LoginForm{
    String username;
    String password;
    String scores;

    public LoginForm() {
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

    @Override
    public String toString() {
        return super.toString() + username + password + "dd";
    }
}