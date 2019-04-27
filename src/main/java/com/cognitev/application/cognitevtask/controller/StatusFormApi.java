package com.cognitev.application.cognitevtask.controller;

import com.cognitev.application.cognitevtask.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Eslam
 *
 * Usage:  User Status API
 */
@RestController
public class StatusFormApi {

    @Autowired
    private StatusService  statusService;

    @RequestMapping(value = "/user-status", method = RequestMethod.POST)
    public ResponseEntity<Object> userStatus(@RequestParam(value = "phoneNumber") String phoneNumber,@RequestHeader(value="Authorization") String AuthorizationToken, @RequestParam(value = "status") String status) {

        return statusService.userStatus(phoneNumber,status);
    }
}
