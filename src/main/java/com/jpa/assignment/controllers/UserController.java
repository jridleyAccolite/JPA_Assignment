package com.jpa.assignment.controllers;

import com.jpa.assignment.models.User;
import com.jpa.assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    // using JPA methods

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/users/add")
    public String addUser(@RequestBody User user){
        return service.addOrUpdateUser(user);
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return service.deleteUser(id);
    }

    // using Query

    @GetMapping(value = "/q/users")
    public ResponseEntity<List<User>> getUsersQuery(){
        return new ResponseEntity<>(service.getAllUsersQuery(), HttpStatus.OK);
    }

    @PostMapping(value = "/q/users/add")
    public String insertUserQuery(@RequestBody User user){
        return service.insertUserQuery(user);
    }
}
