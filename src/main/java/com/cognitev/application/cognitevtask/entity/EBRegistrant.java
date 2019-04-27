package com.cognitev.application.cognitevtask.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eslam
 *
 * Usage:  Registrant Entity
 */

@Entity
@Table(name = "registrant")
public class EBRegistrant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "registerantId")
    private int registerantId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "country_code")
    private String country_code;


    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private Date birthdate;

    @JsonIgnore
    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "email",unique = true)
    private String email;

    public int getRegisterantId() {
        return registerantId;
    }

    public void setRegisterantId(int registerantId) {
        this.registerantId = registerantId;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
