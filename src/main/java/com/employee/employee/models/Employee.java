package com.employee.employee.models;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
public class Employee {
    @Id
    private ObjectId id;
    private String firstname;
    private String lastName;
    private String email;

    @DBRef
    private Department department;

    @DBRef
    private Role role;
    private double salary;
    private LocalDate localDate;

    @DBRef
    private Project[] projectAssigments;

    public ObjectId getId(){
        return id;
    }
    public String getFirstName(){
        return firstname;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public Department getDepartment(){
        return department;
    }
    public Role getRole(){
        return role;
    }
    public double getSalary(){
        return salary;
    }
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDepartment(Department department){
        this.department = department;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setProjectAssignments(Project[] projectAssignments){
        this.projectAssigments = projectAssignments;
    }
    public LocalDate getLocalDate(){
        return localDate;
    }
    public void setLocalDate(LocalDate localDate){
        this.localDate = localDate;
    }
    public Project[] getProjectAssigments(){
        return projectAssigments;
    }

}
