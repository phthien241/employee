package com.employee.employee.models;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project_assignments")
public class ProjectAssignment {
    private ObjectId id;

    @DBRef
    private Employee employee;
    
    private Project project;
    private LocalDate assignedDate;
    
    @DBRef
    private Role role;

    public ProjectAssignment(Employee employee, Project project, LocalDate assignedDate, Role role) {
        this.employee = employee;
        this.project = project;
        this.assignedDate = assignedDate;
        this.role = role;
    }

    public ObjectId getId(){
        return id;
    }
    public Employee getEmployee(){
        return employee;
    }
    public Project getProject(){
        return project;
    }
    public LocalDate getAssignedDate(){
        return assignedDate;
    }
    public Role getRole(){
        return role;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public void setProject(Project project){
        this.project = project;
    }
    public void setAssignedDate(LocalDate assignedDate){
        this.assignedDate = assignedDate;
    }
    public void setRole(Role role){
        this.role = role;
    }

}
