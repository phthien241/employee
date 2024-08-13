package com.employee.employee.Exception;

public class EmployeeUpdateException extends RuntimeException {
    public EmployeeUpdateException(String message) {
        super(message);
    }

    public EmployeeUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
