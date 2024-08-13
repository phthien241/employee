package com.employee.employee.DTO;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import com.employee.employee.models.Employee;

public class ProjectDTO {
    private ObjectId id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private Employee[] teamMembers;

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Employee[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Employee[] teamMembers) {
        this.teamMembers = teamMembers;
    }
}
