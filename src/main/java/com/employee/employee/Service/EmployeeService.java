package com.employee.employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employee.employee.DTO.EmployeeBasicDTO;
import com.employee.employee.DTO.EmployeeDTO;
import com.employee.employee.Exception.EmployeeNotFoundException;
import com.employee.employee.models.Department;
import com.employee.employee.models.Employee;
import com.employee.employee.models.Project;
import com.employee.employee.models.Role;
import com.employee.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ProjectService projectService;

    public Optional<Employee> getEmployeeById(ObjectId id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id);
    }

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

    public String createEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return "Employee created successfully";
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create employee: " + e.getMessage(), e);
        }
    }

    public String updateEmployee(Employee employee) throws RuntimeException, IllegalArgumentException {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
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
    }

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO(null, employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartment().getId().toHexString(),employee.getRole().getId().toHexString(),employee.getSalary(),employee.getLocalDate(),null);

        if (employee.getId() != null) {
            dto.setId(employee.getId().toHexString());
        }
        
        if (employee.getProjectAssigments() != null) {
            String[] projectAssignmentIds = new String[employee.getProjectAssigments().length];
            for (int i = 0; i < employee.getProjectAssigments().length; i++) {
                projectAssignmentIds[i] = employee.getProjectAssigments()[i].getId().toHexString();
            }
            dto.setProjectAssigmentIds(projectAssignmentIds);
        }

        return dto;
    }

    public Employee toEnity(EmployeeDTO employeeDTO){
        Employee employee = new Employee(new ObjectId(employeeDTO.getId()),employeeDTO.getFirstname(),employeeDTO.getLastName(),employeeDTO.getEmail(),null,null,employeeDTO.getSalary(),employeeDTO.getLocalDate(),null);
        if(employeeDTO.getDepartmentId()!=null){
            Department department = departmentService.getDepartmentById(new ObjectId(employeeDTO.getDepartmentId())).orElseThrow(()->new RuntimeException("No department found"));
            employee.setDepartment(department);
        }
        if(employeeDTO.getRoleId()!=null){
            Role role = roleService.getById(new ObjectId(employeeDTO.getRoleId())).orElseThrow(()->new RuntimeException("No Role found"));
            employee.setRole(role);
        }
        
        if(employeeDTO.getProjectAssigmentIds()!=null){
            Project[] projectAssignments = new Project[employeeDTO.getProjectAssigmentIds().length];
            for(int i = 0; i < projectAssignments.length;i++){
                ObjectId id = new ObjectId(employeeDTO.getProjectAssigmentIds()[i]);
                projectAssignments[i] = projectService.getById(id).orElseThrow(()->new RuntimeException("Project assignment not found"));
            }
            employee.setProjectAssignments(projectAssignments);
        }
        return employee;
    }
    
}
