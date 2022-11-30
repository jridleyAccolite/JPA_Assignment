package com.jpa.assignment.services;

import com.jpa.assignment.models.LoginDetails;
import com.jpa.assignment.repositories.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepo repo;

    public List<LoginDetails> getAllLogins(){
        return (List) repo.findAll();
    }

    public String addOrUpdateLogin(LoginDetails login){
        repo.save(login);
        return "successful add/update of login";
    }

    public String deleteLogin(int loginId){
        repo.deleteById(loginId);
        return "login number "+ loginId + " successfully deleted";
    }

    public List<LoginDetails> findLoginsQuery(){
        return repo.findLoginsByQuery();
    }

    public String insertLoginQuery(LoginDetails login){
        repo.insertLoginByQuery(login.getId(), login.getPassword(), login.getActive());
        return "Login successfully added";
    }

    public String deleteLoginQuery(int id){
        repo.deleteLoginByQuery(id);
        return "Login " + id + " deleted";
    }
}
