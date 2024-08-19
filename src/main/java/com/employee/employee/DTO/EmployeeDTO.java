package com.employee.employee.DTO;

import java.time.LocalDate;



public class EmployeeDTO {
    private String id;
    private String firstname;
    private String lastName;
    private String email;
    private String departmentId;
    private String roleId;
    private double salary;
    private LocalDate localDate;
    private String[] projectAssigmentIds;
    public EmployeeDTO() {
        // Default constructor
    }

    public EmployeeDTO(String id, String firstname, String lastName, String email, String departmentId, String roleId, double salary, LocalDate localDate, String[] projectAssigmentIds) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.salary = salary;
        this.localDate = localDate;
        this.projectAssigmentIds = projectAssigmentIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String[] getProjectAssigmentIds() {
        return projectAssigmentIds;
    }

    public void setProjectAssigmentIds(String[] projectAssigmentIds) {
        this.projectAssigmentIds = projectAssigmentIds;
    }
}
