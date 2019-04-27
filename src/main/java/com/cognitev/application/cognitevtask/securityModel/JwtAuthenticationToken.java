package com.cognitev.application.cognitevtask.securityModel;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


/**
 * Created by Eslam
 *
 * Usage: Authorization for Saving User Token
 */

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
