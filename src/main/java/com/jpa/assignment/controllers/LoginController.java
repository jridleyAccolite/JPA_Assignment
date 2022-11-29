package com.jpa.assignment.controllers;

import com.jpa.assignment.models.LoginDetails;
import com.jpa.assignment.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping(value = "/logins")
    public ResponseEntity<List<LoginDetails>> getLogins(){
        return new ResponseEntity<>(service.getAllLogins(), HttpStatus.OK);
    }

    @PostMapping(value = "/logins/add")
    public String addLogin(@RequestBody LoginDetails login){
        return service.addOrUpdateLogin(login);
    }

    @DeleteMapping(value = "/logins/delete/{id}")
    public String deleteLogin(@PathVariable("id") int id){
        return service.deleteLogin(id);
    }
}
