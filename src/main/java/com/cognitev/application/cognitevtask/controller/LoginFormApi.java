package com.cognitev.application.cognitevtask.controller;

import com.cognitev.application.cognitevtask.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eslam.
 *
 * Usage:  Login API
 */
@RestController
public class LoginFormApi {

    @Autowired
    private LoginService loginService;



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestParam(value = "phoneNumber") String phoneNumber, @RequestParam(value = "password") String password){
                return loginService.userLogin(phoneNumber,password);
    }
}
