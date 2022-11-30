package com.jpa.assignment.controllers;

import com.jpa.assignment.models.UserPermission;
import com.jpa.assignment.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionsController {

    @Autowired
    PermissionService service;

    @GetMapping(value = "/permissions")
    public ResponseEntity<List<UserPermission>> getAllPermissions(){
        return new ResponseEntity<>(service.getAllPermissions(), HttpStatus.OK);
    }

    @PostMapping(value = "/permissions/add")
    public String addPermission(@RequestBody UserPermission p){
        return service.addOrUpdatePermission(p);
    }

    @DeleteMapping(value = "/permissions/delete/{id}")
    public String deletePermission(@PathVariable("id") int id){
        return service.deletePermission(id);
    }

    @GetMapping(value = "/q/permissions")
    public ResponseEntity<List<UserPermission>> findPermissionsQuery(){
        return new ResponseEntity<>(service.findPermissionsQuery(), HttpStatus.OK);
    }

    @PostMapping(value = "/q/permissions/add")
    public String insertPermissionQuery(@RequestBody UserPermission permission){
        return service.insertPermissionQuery(permission);
    }

    @DeleteMapping(value = "/q/permissions/delete/{id}")
    public String deletePermissionQuery(@PathVariable("id") int id){
        return service.deletePermissionQuery(id);
    }

}
