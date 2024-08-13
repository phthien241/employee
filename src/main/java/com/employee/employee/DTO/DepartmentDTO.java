package com.employee.employee.DTO;

import org.bson.types.ObjectId;

import com.employee.employee.models.Employee;

public class DepartmentDTO {
    private ObjectId id;
    private String name;
    private String location;
    private Employee[] employees;
    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}
