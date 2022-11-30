package com.jpa.assignment.repositories;

import com.jpa.assignment.models.LoginDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepo extends CrudRepository<LoginDetails, Integer> {

    @Query("FROM LoginDetails l")
    List<LoginDetails> findLoginsByQuery();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO login (id, password, is_active) VALUES (:id, :password, :isActive)", nativeQuery = true)
    void insertLoginByQuery(@Param("id") int id, @Param("password") String password, @Param("isActive") Boolean isActive);

    @Transactional
    @Modifying
    @Query("DELETE FROM LoginDetails l WHERE l.id = :id")
    void deleteLoginByQuery(@Param("id") int id);
}
