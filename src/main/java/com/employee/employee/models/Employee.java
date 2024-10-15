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
    private String driverLicenseId;
    private String firstname;
    private String lastName;
    private String email;

    @DBRef
    private Department department;

    @DBRef
    private Role role;
    private double salary;
    private LocalDate localDate;

    public Employee(){}

    public Employee(ObjectId id, String driverLicenseId, String firstname, String lastName, String email, Department department, Role role, double salary, LocalDate localDate) {
        this.id = id;
        this.driverLicenseId = driverLicenseId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.localDate = localDate;
    }

    public ObjectId getId(){
        return id;
    }
    public String getDriverLicenseId(){
        return driverLicenseId;
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
    public void setDriverLicenseId(String driverLicenseId){
        this.driverLicenseId = driverLicenseId;
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

    public LocalDate getLocalDate(){
        return localDate;
    }
    public void setLocalDate(LocalDate localDate){
        this.localDate = localDate;
    }


}
