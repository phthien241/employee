package com.employee.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.DTO.ApiResponse;
import com.employee.employee.Service.DepartmentService;
import com.employee.employee.models.Department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("{name}")
    public ResponseEntity<ApiResponse<Department>> getDepartmentByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name)
                .map(department -> ResponseEntity.ok(new ApiResponse<>("Department found", department)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>("Department not found")));
    }
}
