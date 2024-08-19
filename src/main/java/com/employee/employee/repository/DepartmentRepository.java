package com.employee.employee.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, ObjectId> {
    Optional<Department> findByName(String name);
    Optional<Department> findById(ObjectId id);
}
