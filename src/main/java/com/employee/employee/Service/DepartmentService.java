package com.employee.employee.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.models.Department;
import com.employee.employee.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Optional<Department> getDepartmentByName(String name){
        return departmentRepository.findByName(name);
    }
}
