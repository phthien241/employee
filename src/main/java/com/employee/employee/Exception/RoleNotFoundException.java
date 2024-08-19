package com.employee.employee.Exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message){
        super(message);
    }
}
