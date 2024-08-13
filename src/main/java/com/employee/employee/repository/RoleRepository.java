package com.employee.employee.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role,ObjectId> {
    Optional<Role> findByTitle(String title);
}
