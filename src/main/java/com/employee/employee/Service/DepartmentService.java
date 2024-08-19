package com.employee.employee.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employee.employee.DTO.DepartmentDTO;
import com.employee.employee.Exception.EmployeeNotFoundException;
import com.employee.employee.models.Department;
import com.employee.employee.models.Employee;
import com.employee.employee.repository.DepartmentRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeService employeeService;

    public Optional<Department> getDepartmentById(ObjectId id){
        return departmentRepository.findById(id);
    }

    public Optional<Department> getDepartmentByName(String name){
        return departmentRepository.findByName(name);
    }

    public String createDepartment(DepartmentDTO departmentDTO) throws DataAccessException{
        Department department = toEnity(departmentDTO);
        departmentRepository.save(department);
        return "Create Department Successfully";
    }

    public String updateDepartment(DepartmentDTO departmentDTO) throws IllegalArgumentException, DataAccessException, ConstraintViolationException{
        if(departmentDTO.getId()==null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        Department department = toEnity(departmentDTO);
        departmentRepository.save(department);
        return "Update Department Successfully";
    }

    public DepartmentDTO toDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();

        if (department.getId() != null) {
            dto.setId(department.getId().toHexString());
        }

        dto.setName(department.getName());
        dto.setLocation(department.getLocation());

        if (department.getEmployees() != null) {
            String[] employeeIds = new String[department.getEmployees().length];
            for (int i = 0; i < department.getEmployees().length; i++) {
                employeeIds[i] = department.getEmployees()[i].getId().toHexString();
            }
            dto.setEmployees(employeeIds);
        }

        return dto;
    }

    public Department toEnity(DepartmentDTO departmentDTO){
        Department department = new Department(new ObjectId(departmentDTO.getId()),departmentDTO.getName(),departmentDTO.getLocation(),null);
        if(departmentDTO.getEmployees()!=null){
            Employee[] employees = new Employee[departmentDTO.getEmployees().length];
            for(int i = 0; i < employees.length;i++){
                ObjectId id = new ObjectId(departmentDTO.getEmployees()[i]);
                employees[i] = employeeService.getEmployeeById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
            }
            department.setEmployees(employees);
        }
        return department;
    }
}
