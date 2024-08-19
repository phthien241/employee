package com.employee.employee.DTO;

public class DepartmentDTO {
    private String id;
    private String name;
    private String location;
    private String[] employeeIds;
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
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

    public String[] getEmployees() {
        return employeeIds;
    }

    public void setEmployees(String[] employeeIds) {
        this.employeeIds = employeeIds;
    }
}
