package com.employee.employee.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee,ObjectId>{
    Optional<Employee> findById(ObjectId id);
    Optional<Employee> findByEmail(String email);
    List<Employee> findByDepartment_Id(ObjectId departmentId);
    List<Employee> findByRole_Id(ObjectId roleId);
    List<Employee> findByProjectAssigments_Id(ObjectId projectId);

}
