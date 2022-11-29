package com.jpa.assignment.services;

import com.jpa.assignment.models.User;
import com.jpa.assignment.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public List<User> getAllUsers(){
        return (List) repo.findAll();
    }

    public String addOrUpdateUser(User user){
        repo.save(user);
        return "user successfully added/updated";
    }

    public String deleteUser(int userId){
        repo.deleteById(userId);
        return "user number " + userId + " successfully deleted";
    }
}
