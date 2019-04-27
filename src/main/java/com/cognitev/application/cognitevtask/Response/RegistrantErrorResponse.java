package com.cognitev.application.cognitevtask.Response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Eslam.
 *
 * Usage: Registrant Error Response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrantErrorResponse {

    private HashMap<String,String> first_name;
    private HashMap<String,String> last_name;
    private HashMap<String,String> country_code;
    private LinkedHashMap<String,String> phone_number;
    private HashMap<String,String> gender;
    private HashMap<String,String> birthdate;
    private HashMap<String,String> avatar;
    private HashMap<String,String> email;

    public HashMap<String, String> getFirst_name() {
        return first_name;
    }

    public void setFirst_name(HashMap<String, String> first_name) {
        this.first_name = first_name;
    }

    public HashMap<String, String> getLast_name() {
        return last_name;
    }

    public void setLast_name(HashMap<String, String> last_name) {
        this.last_name = last_name;
    }

    public HashMap<String, String> getCountry_code() {
        return country_code;
    }

    public void setCountry_code(HashMap<String, String> country_code) {
        this.country_code = country_code;
    }

    public  LinkedHashMap<String, String> getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(LinkedHashMap<String, String> phone_number) {
        this.phone_number = phone_number;
    }

    public HashMap<String, String> getGender() {
        return gender;
    }

    public void setGender(HashMap<String, String> gender) {
        this.gender = gender;
    }

    public HashMap<String, String> getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(HashMap<String, String> birthdate) {
        this.birthdate = birthdate;
    }

    public HashMap<String, String> getAvatar() {
        return avatar;
    }

    public void setAvatar(HashMap<String, String> avatar) {
        this.avatar = avatar;
    }

    public HashMap<String, String> getEmail() {
        return email;
    }

    public void setEmail(HashMap<String, String> email) {
        this.email = email;
    }
}
