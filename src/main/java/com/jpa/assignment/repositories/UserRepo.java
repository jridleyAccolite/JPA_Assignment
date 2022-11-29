package com.jpa.assignment.repositories;

import com.jpa.assignment.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u")
    List<User> findAllUsers();




    /*@Query(value = "INSERT INTO User (id, loginId, name, address, contactNo, type) VALUES (:u.id, :u.loginId, :u.name, :u.address, :u.contactNo, :u.type)")
    List<User> insertUser(@Param("u") User u);*/
}
