package com.employee.employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employee.employee.DTO.EmployeeBasicDTO;
import com.employee.employee.Exception.EmployeeNotFoundException;
import com.employee.employee.Exception.EmployeeUpdateException;
import com.employee.employee.models.Employee;
import com.employee.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<EmployeeBasicDTO> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .map(employee -> new EmployeeBasicDTO(employee.getId(), employee.getFirstName(), employee.getLastName(),
                        employee.getEmail(), employee.getDepartment(), employee.getRole(), employee.getLocalDate()));
    }

    public List<EmployeeBasicDTO> getEmployeeByDepartment(ObjectId departmentId) {
        List<Employee> employees = employeeRepository.findByDepartment_Id(departmentId);
        return employees.stream()
                .map(employee -> new EmployeeBasicDTO(employee.getId(), employee.getFirstName(), employee.getLastName(),
                        employee.getEmail(), employee.getDepartment(), employee.getRole(), employee.getLocalDate()))
                .collect(Collectors.toList());
    }

    public List<EmployeeBasicDTO> getEmployeesByRole(ObjectId roleId) {
        List<Employee> employees = employeeRepository.findByRole_Id(roleId);
        return employees.stream()
                .map(employee -> new EmployeeBasicDTO(employee.getId(), employee.getFirstName(), employee.getLastName(),
                        employee.getEmail(), employee.getDepartment(), employee.getRole(), employee.getLocalDate()))
                .collect(Collectors.toList());
    }

    public List<EmployeeBasicDTO> getEmployeesByProjectAssignments(ObjectId projectId) {
        List<Employee> employees = employeeRepository.findByProjectAssigments_Id(projectId);
        return employees.stream()
                .map(employee -> new EmployeeBasicDTO(employee.getId(), employee.getFirstName(), employee.getLastName(),
                        employee.getEmail(), employee.getDepartment(), employee.getRole(), employee.getLocalDate()))
                .collect(Collectors.toList());
    }

    public String createEmployee(Employee employee){
        try{
            employeeRepository.save(employee);
            return "Employee created successfully";
        }catch (DataAccessException e){
            throw new RuntimeException("Failed to create employee: "+e.getMessage(),e);
        }
    }

    public String updateEmployee(Employee employee) throws EmployeeNotFoundException{
        if(employee.getId()==null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        try{
            Employee existingEmployee = employeeRepository.findById(employee.getId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employee.getId()));            
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setRole(employee.getRole());
            existingEmployee.setLocalDate(employee.getLocalDate());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setProjectAssignments(employee.getProjectAssigments());
            employeeRepository.save(existingEmployee);
            return "Employee updated successfully";
        }catch(RuntimeException e){
            throw new EmployeeUpdateException("An error occurred while updating the employee with ID: " + employee.getId(), e);
        }
    }
}
