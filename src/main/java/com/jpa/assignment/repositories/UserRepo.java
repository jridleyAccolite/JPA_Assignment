package com.jpa.assignment.repositories;

import com.jpa.assignment.models.UserDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<UserDetails, Integer> {

    @Query(value = "SELECT u FROM UserDetails u")
    List<UserDetails> findAllUsers();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_details (id, login_id, name, address, contact_no, type) VALUES (:id, :loginId, :name, :address, :contactNo, :type)", nativeQuery = true)
    void insertUser(@Param("id") int id, @Param("loginId") int loginId, @Param("name") String name, @Param("address") String address, @Param("contactNo") String contactNo, @Param("type") String type);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM UserDetails u WHERE u.id = :id")
    void deleteUserQuery(@Param("id") int id);
}
