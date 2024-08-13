package com.employee.employee.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project,ObjectId> {
    Optional<Project> findByName(String name);
}
