package com.employee.employee.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "roles")
public class Role {
    @Id
    public ObjectId id;

    @NotNull
    @Indexed(unique = true)
    public String title;
    public String description;

    
    public double minSalary;
    public double maxSalary;

    public ObjectId getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
   
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public double getMinSalary() {
        return minSalary;
    }
    
    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }
    
    public double getMaxSalary() {
        return maxSalary;
    }
    
    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
}
