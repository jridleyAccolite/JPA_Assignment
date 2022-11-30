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
        System.out.println("service called");
        /*Query q = entityManager.createQuery("INSERT INTO User (id, loginId, name, address, contactNo, type) VALUES (?1, ?2, ?3, ?4, ?5, ?6)");
        q.setParameter(1, user.getId());
        q.setParameter(2, user.getLoginId());
        q.setParameter(3, user.getName());
        q.setParameter(4, user.getAddress());
        q.setParameter(5, user.getContactNo());
        q.setParameter(6, user.getType());
        q.executeUpdate();
        entityManager.close();*/
        repo.insertUser(userDetails.getId(), userDetails.getLoginId(), userDetails.getName(), userDetails.getAddress(), userDetails.getContactNo(), userDetails.getType());
        return "User successfully added";
    }
}
