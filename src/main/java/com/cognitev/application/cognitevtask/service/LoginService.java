package com.cognitev.application.cognitevtask.service;

import com.cognitev.application.cognitevtask.Repositery.RegistrantRepo;
import com.cognitev.application.cognitevtask.entity.EBRegistrant;
import com.cognitev.application.cognitevtask.security.JwtGenerator;
import com.cognitev.application.cognitevtask.securityModel.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Eslam
 *
 * Usage: Login Service to make Login for user and return Auth-Token.
 */
@Service
public class LoginService {

    @Autowired
    private RegistrantRepo registrantRepo;

    @Autowired
    private JwtGenerator jwtGenerator;


    public ResponseEntity<Object> userLogin(String phoneNumber, String password) {
        List<EBRegistrant>  registrant= registrantRepo.findByPhoneNumber(phoneNumber);
        if(registrant.size() == 0){
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        HashMap<String,String> authToken = new HashMap<>();
        JwtUser user = new JwtUser();
        user.setId(registrant.get(0).getRegisterantId());
        user.setPhoneNumber(registrant.get(0).getPhoneNumber());
        user.setRole("Admin");

        String token = jwtGenerator.generate(user);
        authToken.put("Token",token);
        return new ResponseEntity<>(authToken, HttpStatus.CREATED);
    }
}
