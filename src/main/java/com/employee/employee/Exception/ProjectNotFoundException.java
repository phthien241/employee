package com.employee.employee.Exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message){
        super(message);
    }
}
