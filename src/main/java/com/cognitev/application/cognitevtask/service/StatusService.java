package com.cognitev.application.cognitevtask.service;

import com.cognitev.application.cognitevtask.Repositery.RegistrantRepo;
import com.cognitev.application.cognitevtask.Repositery.UserStatusRepo;
import com.cognitev.application.cognitevtask.entity.EBRegistrant;
import com.cognitev.application.cognitevtask.entity.EBUserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eslam
 *
 * Usage: Status Service to Add New Status for any User.
 */
@Service
public class StatusService {

    @Autowired
    private RegistrantRepo registrantRepo;

    @Autowired
    private UserStatusRepo userStatusRepo;

    public ResponseEntity<Object> userStatus(String phoneNumber, String status) {
        List<EBRegistrant> registrant= registrantRepo.findByPhoneNumber(phoneNumber);
        if(registrant.size() == 0){
            return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
        }

        EBUserStatus  userStatus = addUserStatus(status,registrant.get(0));
        return new ResponseEntity<>(userStatus, HttpStatus.CREATED);

    }

    private EBUserStatus addUserStatus(String status,EBRegistrant registrant){
        EBUserStatus userStatus  =  new EBUserStatus();
        userStatus.setUserStatus(status);
        userStatus.setRegisterantId(registrant);

        return userStatusRepo.save(userStatus);
    }
}
