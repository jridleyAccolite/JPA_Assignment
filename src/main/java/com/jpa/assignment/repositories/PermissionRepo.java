package com.jpa.assignment.repositories;

import com.jpa.assignment.models.UserPermission;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepo extends CrudRepository<UserPermission, Integer> {

    @Query("FROM UserPermission u")
    List<UserPermission> findPermissionsbyQuery();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO permissions (user_id, permission_level) VALUES (:userId, :level)", nativeQuery = true)
    void insertPermissionByQuery(@Param("userId") int userId, @Param("level") int permissionLevel);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserPermission u WHERE u.userId = :id")
    void deletePermissionByQuery(@Param("id") int id);
}
