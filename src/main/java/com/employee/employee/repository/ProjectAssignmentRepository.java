package com.employee.employee.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.ProjectAssignment;

@Repository
public interface ProjectAssignmentRepository extends MongoRepository<ProjectAssignment,ObjectId> {
    Optional<ProjectAssignment> findById(ObjectId id);
}
