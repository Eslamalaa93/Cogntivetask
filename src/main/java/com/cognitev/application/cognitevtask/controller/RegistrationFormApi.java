package com.cognitev.application.cognitevtask.controller;

import com.cognitev.application.cognitevtask.dto.Registrant;
import com.cognitev.application.cognitevtask.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;

/**
 * Created by Eslam.
 *
 * Usage:  Registration API
 */

@RestController
public class RegistrationFormApi {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/register-user", method = RequestMethod.POST,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> userRegistration(@RequestPart(value = "first_name") String first_name,@RequestPart(value = "last_name") String last_name,@RequestPart(value = "country_code") String country_code,@RequestPart(value = "phone_number") String phone_number,@RequestPart(value = "gender") String gender,@RequestPart(value = "birthdate") String birthdate,@RequestPart(value = "avatar") MultipartFile avatar,@RequestPart(value = "email") String email) {

        Registrant  registrant = new Registrant();
        registrant.setFirst_name(first_name);
        registrant.setLast_name(last_name);
        registrant.setEmail(email);
        registrant.setAvatar(avatar);
        registrant.setBirthdate(birthdate);
        registrant.setGender(gender);
        registrant.setCountry_code(country_code);
        registrant.setPhone_number(phone_number);

        return  registrationService.addRegistrant(registrant);
    }

}
