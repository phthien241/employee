package com.employee.employee.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departments")
public class Department {

    private ObjectId id;
    private String name;
    private String location;
    private Employee[] employees;

    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public Employee[] getEmployees(){
        return employees;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setEmployees(Employee[] employees){
        this.employees = employees;
    }

}
