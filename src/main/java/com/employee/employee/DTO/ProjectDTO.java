package com.employee.employee.DTO;

import java.time.LocalDate;



public class ProjectDTO {
    private String id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private String[] teamMemberIds;

    public ProjectDTO(String id, String name, String description, LocalDate startDate, LocalDate endDate, double budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id){
        this.id = Id;
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

    public String[] getTeamMemberIds() {
        return teamMemberIds;
    }

    public void setTeamMemberIds(String[] teamMemberIds) {
        this.teamMemberIds = teamMemberIds;
    }
}
