package com.jpa.assignment.repositories;

import com.jpa.assignment.models.UserPermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends CrudRepository<UserPermission, Integer> {
}
