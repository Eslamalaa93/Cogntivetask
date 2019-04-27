package com.cognitev.application.cognitevtask.service;

import com.cognitev.application.cognitevtask.Repositery.RegistrantRepo;
import com.cognitev.application.cognitevtask.Response.RegistrantErrorResponse;
import com.cognitev.application.cognitevtask.dto.Registrant;
import com.cognitev.application.cognitevtask.entity.EBRegistrant;
import com.cognitev.application.cognitevtask.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


/**
 * Created by Eslam
 *
 * Usage: Registration Service to Add New User with Custom Validation.
 */

@Service
public class RegistrationService {

    @Autowired
    private RegistrantRepo registrantRepo;

    @Autowired
    private ValidationService validationService;

    public ResponseEntity<Object> addRegistrant(Registrant registrant) {
        RegistrantErrorResponse registrantErrorResponse = validationService.validateRegistrant(registrant);
        if(registrantErrorResponse == null){
                return new ResponseEntity<>(addNewRegistrant(registrant), HttpStatus.CREATED);
        }

        HashMap<String,RegistrantErrorResponse> errorMsg = new HashMap<>();
        errorMsg.put("error",registrantErrorResponse);
        return  new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }

    private EBRegistrant addNewRegistrant(Registrant registrant) {
        try {

            EBRegistrant newRegistrant = new EBRegistrant();
            newRegistrant.setFirst_name(registrant.getFirst_name());
            newRegistrant.setLast_name(registrant.getLast_name());
            newRegistrant.setAvatar(registrant.getAvatar().getBytes());
            Date date= new SimpleDateFormat("yyyy-MM-dd").parse(registrant.getBirthdate());
            newRegistrant.setBirthdate(date);
            newRegistrant.setCountry_code(registrant.getCountry_code());
            newRegistrant.setEmail(registrant.getEmail());
            newRegistrant.setGender(registrant.getGender());
            newRegistrant.setPhoneNumber(registrant.getPhone_number());
            return registrantRepo.save(newRegistrant);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
