package com.jpa.assignment.services;

import com.jpa.assignment.models.UserPermission;
import com.jpa.assignment.repositories.PermissionRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    PermissionRepo repo;

    public List<UserPermission> getAllPermissions(){
        return (List) repo.findAll();
    }

    public String addOrUpdatePermission(UserPermission p){
        repo.save(p);
        return "Permission successfully added/updated";
    }

    public String deletePermission(int id){
        repo.deleteById(id);
        return "Permission number " + id + " successfully deleted";
    }

    public List<UserPermission> findPermissionsQuery(){
        return repo.findPermissionsbyQuery();
    }

    public String insertPermissionQuery(UserPermission permission){
        repo.insertPermissionByQuery(permission.getUserId(), permission.getPermissionLevel());
        return "Permission succesfully added";
    }

    public String deletePermissionQuery(int id){
        repo.deletePermissionByQuery(id);
        return "Permission with user id " + id + " deleted";
    }
}
