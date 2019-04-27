package com.cognitev.application.cognitevtask.securityModel;


/**
 * Created by Eslam
 *
 * Usage: Authorization  for User Login Info to generate Auth-Token ID.
 */

public class JwtUser {


    private String phoneNumber;
    private long id;
    private String role;



    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
