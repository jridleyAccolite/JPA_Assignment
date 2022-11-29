package com.jpa.assignment.repositories;

import com.jpa.assignment.models.LoginDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends CrudRepository<LoginDetails, Integer> {
}
