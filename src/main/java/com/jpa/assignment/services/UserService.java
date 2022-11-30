package com.jpa.assignment.services;

import com.jpa.assignment.models.UserDetails;
import com.jpa.assignment.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public List<UserDetails> getAllUsers(){
        return (List) repo.findAll();
    }

    public String addOrUpdateUser(UserDetails userDetails){
        repo.save(userDetails);
        return "user successfully added/updated";
    }

    public String deleteUser(int userId){
        repo.deleteById(userId);
        return "user number " + userId + " successfully deleted";
    }

    public List<UserDetails> getAllUsersQuery(){
        return repo.findAllUsers();
    }

    public String insertUserQuery(UserDetails userDetails){
        repo.insertUser(userDetails.getId(), userDetails.getLoginId(), userDetails.getName(), userDetails.getAddress(), userDetails.getContactNo(), userDetails.getType());
        return "User successfully added";
    }

    public String deleteUserQuery(int id){
        repo.deleteUserQuery(id);
        return "User " + id + " deleted";
    }
}
