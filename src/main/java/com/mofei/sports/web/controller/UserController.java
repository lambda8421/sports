package com.mofei.sports.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public void register(){

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login( @RequestBody LoginForm loginForm){


        System.out.println(loginForm.toString());
        return "xx";
    }

    class LoginForm{
        String username;
        String password;

        @Override
        public String toString() {
            return super.toString() + username + password + "dd";
        }
    }
}
