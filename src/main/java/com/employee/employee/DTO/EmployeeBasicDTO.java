package com.employee.employee.DTO;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import com.employee.employee.models.Department;
import com.employee.employee.models.Role;

public class EmployeeBasicDTO {
    private ObjectId id;
    private String firstname;
    private String lastName;
    private String email;
    private Department department;
    private Role role;
    private LocalDate localDate;

    public EmployeeBasicDTO(ObjectId id, String firstname, String lastName, String email, Department department, Role role, LocalDate localDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.role = role;
        this.localDate = localDate;
    }

    public ObjectId getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
