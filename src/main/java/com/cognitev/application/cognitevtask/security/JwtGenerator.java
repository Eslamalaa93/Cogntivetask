package com.cognitev.application.cognitevtask.security;


import com.cognitev.application.cognitevtask.securityModel.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;


/**
 * Created by Eslam
 *
 * Usage: Authorization for Generate Token Id for Login User
 */

@Component
public class JwtGenerator {

    private String secretKey = "cognitve";

    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getPhoneNumber());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
