package com.employee.employee.models;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "projects")
public class Project {
    private ObjectId id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private double budget;

    @DBRef
    private Employee[] teamMembers;

    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }
    public double getBudget(){
        return budget;
    }
    public Employee[] getTeamMembers(){
        return teamMembers;
    }
    public void setId(ObjectId Id){
        this.id = Id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }
    public void setBudget(double budget){
        this.budget = budget;
    }
    public void setTeamMembers(Employee[] teamMembers){
        this.teamMembers = teamMembers;
    }
}
