package com.employee.employee.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.DTO.ApiResponse;
import com.employee.employee.DTO.EmployeeBasicDTO;
import com.employee.employee.Service.EmployeeService;
import com.employee.employee.models.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<EmployeeBasicDTO>> getEmployeeByEmail(@PathVariable String email) {
        return employeeService.getEmployeeByEmail(email)
                .map(employee -> ResponseEntity.ok(new ApiResponse<>("Employee found successfully", employee)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>("Employee with email " + email + " not found")));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<ApiResponse<List<EmployeeBasicDTO>>> getEmployeeByDepartment(@PathVariable ObjectId departmentId) {
        List<EmployeeBasicDTO> employees = employeeService.getEmployeeByDepartment(departmentId);
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No employees found for the given department"));
        } else {
            return ResponseEntity.ok(new ApiResponse<>("Employees found successfully", employees));
        }
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<ApiResponse<List<EmployeeBasicDTO>>> getEmployeesByRole(@PathVariable ObjectId roleId){
        List<EmployeeBasicDTO> employees = employeeService.getEmployeesByRole(roleId);
        if(employees.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("No employees found for the given role"));
        }else{
            return ResponseEntity.ok(new ApiResponse<>("Employees found",employees));
        }
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<ApiResponse<List<EmployeeBasicDTO>>> getEmployeesByProjectAssignments(@PathVariable ObjectId projectId){
        List<EmployeeBasicDTO> employees = employeeService.getEmployeesByProjectAssignments(projectId);
        if(employees.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("No employee found"));
        }else{
            return ResponseEntity.ok(new ApiResponse<>("Employees found",employees));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        String message = employeeService.createEmployee(employee);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        String message =  employeeService.updateEmployee(employee);   
        return ResponseEntity.ok(message);
    }
    
}
