package com.cognitev.application.cognitevtask.validation;

import com.cognitev.application.cognitevtask.Repositery.RegistrantRepo;
import com.cognitev.application.cognitevtask.Response.RegistrantErrorResponse;
import com.cognitev.application.cognitevtask.dto.Registrant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * Created by Eslam
 *
 * Usage: Custom validation for Registration Form.
 */

@Service
public class ValidationService {

    private static Pattern phoneNumberPattern = Pattern.compile(ValidatorConstants.PHONENUMBER.getValue());
    private static Pattern isNumber = Pattern.compile(ValidatorConstants.ISNUMBER.getValue());
    private static Pattern isEmail = Pattern.compile(ValidatorConstants.EMAIL.getValue());
    private static Pattern isDate = Pattern.compile(ValidatorConstants.DATE.getValue());

    @Autowired
    private RegistrantRepo registrantRepo;

    public RegistrantErrorResponse validateRegistrant(Registrant registrant) {
        RegistrantErrorResponse registrantErrorResponse = new RegistrantErrorResponse();
        boolean hasError = false;
        if(isBlank(registrant.getFirst_name())){
            HashMap<String,String>error = new HashMap<>();
            error.put("error","blank");
            registrantErrorResponse.setFirst_name(error);
            hasError = true;
        }
        if(isBlank(registrant.getLast_name())){
            HashMap<String,String>error = new HashMap<>();
            error.put("error","blank");
            registrantErrorResponse.setLast_name(error);
            hasError = true;
        }

        if(isBlank(registrant.getCountry_code())){
            HashMap<String,String>error = new HashMap<>();
            error.put("error","inclusion");
            registrantErrorResponse.setFirst_name(error);
            hasError = true;
        }
        if(isBlank(registrant.getGender())){
            HashMap<String,String>error = new HashMap<>();
            error.put("error","inclusion");
            registrantErrorResponse.setGender(error);
            hasError = true;
        }
        registrantErrorResponse.setPhone_number(validatePhoneNumber(registrant.getPhone_number()));
        registrantErrorResponse.setBirthdate(validateBirthDate(registrant.getBirthdate()));
        registrantErrorResponse.setAvatar(validateAvatar(registrant.getAvatar()));
        registrantErrorResponse.setEmail(validateEmail(registrant.getEmail()));

        if(registrantErrorResponse.getEmail() != null||registrantErrorResponse.getPhone_number()!=null||registrantErrorResponse.getBirthdate()!=null
                || registrantErrorResponse.getAvatar()!=null)
                    hasError = true;



    return hasError ? registrantErrorResponse : null;
    }



    private  boolean isBlank(String value){
        return value == null || value.isEmpty() ? true:false;
    }

    private LinkedHashMap<String,String> validatePhoneNumber(String phoneNumber){
        LinkedHashMap<String,String>errors = new LinkedHashMap<>();
        if(isBlank(phoneNumber))
            errors.put("error","blank");

        else if(!isNumber.matcher(String.valueOf(phoneNumber)).find())
            errors.put("error","not_a_number");

        else if(!phoneNumberPattern.matcher(String.valueOf(phoneNumber)).find())
            errors.put("error","invalid");

        else if (phoneNumber.length() < 14) {
            errors.put("error", "too_short");
            errors.put("count", Integer.toString(phoneNumber.length()-1));
        }
        else if (phoneNumber.length() > 14) {
            errors.put("error", "too_long");
            errors.put("count", Integer.toString(phoneNumber.length()-1));
        }
        else if(registrantRepo.findByPhoneNumber(phoneNumber).size() > 0){
            errors.put("error", "taken");
        }
        return errors.isEmpty()? null :errors;
    }

    private HashMap<String,String> validateEmail(String email){
        HashMap<String,String>errors = new HashMap<>();
        if(isBlank(email))
            errors.put("error","blank");

        else if(!isEmail.matcher(String.valueOf(email)).find()){
            errors.put("error","invalid");
        }
        else if(registrantRepo.findByEmail(email).size() > 0)
            errors.put("error", "taken");


        return errors.isEmpty()? null :errors;
    }
    private HashMap<String,String>validateBirthDate(String birthdate){
        HashMap<String,String>errors = new HashMap<>();
        try {
        if(isBlank(birthdate))
            errors.put("error","blank");

        else if(!isDate.matcher(String.valueOf(birthdate)).find()){
            errors.put("error","invalid");
        }

        else if(new SimpleDateFormat("yyyy-MM-dd").parse(birthdate).after(new Date())){
                    errors.put("error","in_the_future");
                }

        } catch (ParseException e) {
                e.printStackTrace();
            }
        return errors.isEmpty()? null :errors;
    }

    private HashMap<String,String>validateAvatar(MultipartFile avatar){
        HashMap<String,String>errors = new HashMap<>();
        if(avatar == null)
            errors.put("error","blank");

    else if(!avatar.getContentType().equals("image/png") && !avatar.getContentType().equals("image/jpg")&& !avatar.getContentType().equals("image/jpeg")){
            errors.put("error","invalid_content_type");
        }

        return errors.isEmpty()? null :errors;
    }

}
