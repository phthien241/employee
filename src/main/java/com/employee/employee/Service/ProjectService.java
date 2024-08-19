package com.employee.employee.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employee.employee.DTO.ProjectDTO;
import com.employee.employee.Exception.EmployeeNotFoundException;
import com.employee.employee.Exception.ProjectNotFoundException;
import com.employee.employee.Exception.RoleNotFoundException;
import com.employee.employee.models.Employee;
import com.employee.employee.models.Project;
import com.employee.employee.models.ProjectAssignment;
import com.employee.employee.models.Role;
import com.employee.employee.repository.ProjectRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ProjectAssigmentService projectAssigmentService;

    public Optional<Project> getByName(String name) {
        return projectRepository.findByName(name);
    }

    public Optional<Project> getById(ObjectId id) {
        return projectRepository.findById(id);
    }

    public String createProject(Project project, String[] employeeId) throws DataAccessException {
        List<Employee> employees = new ArrayList<>();
        for (String id : employeeId) {
            Employee employee = employeeService.getEmployeeById(new ObjectId(id))
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
            employees.add(employee);
        }
        project.setTeamMembers(employees.toArray(new Employee[0]));
        projectRepository.save(project);
        return "Project created successfully";
    }

    public String updateProject(ProjectDTO updatedProject) throws DataAccessException, ConstraintViolationException {
        ObjectId id = new ObjectId(updatedProject.getId());
        Project existingProject = getById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        existingProject = toEntity(updatedProject);
        projectRepository.save(existingProject);
        return "Update project successfully";
    }

    public String assignProject(String[] employeeId, String projectId, String roleId) throws EmployeeNotFoundException, ProjectNotFoundException, RoleNotFoundException{
        Project project = projectRepository.findById(new ObjectId(projectId)).orElseThrow(()->new ProjectNotFoundException("No project found"));
        Role role = roleService.getById(new ObjectId(roleId)).orElseThrow(()->new RoleNotFoundException("No role found"));
        for(String id : employeeId){
            Employee employee = employeeService.getEmployeeById(new ObjectId(id)).orElseThrow(()->new EmployeeNotFoundException("No employee found"));
            List<Project> projects = Arrays.asList(employee.getProjectAssigments());
            projects.add(project);
            employee.setProjectAssignments(projects.toArray(new Project[0]));
            ProjectAssignment projectAssignment = new ProjectAssignment(employee, project, LocalDate.now(), role);
            projectAssigmentService.createProjectAssignment(projectAssignment);
        }
        return "Assign project successfully";
    }

    public ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO(project.getId().toHexString(), project.getName(), project.getDescription(),
                project.getStartDate(), project.getEndDate(), project.getBudget());
        if (project.getTeamMembers() != null) {
            String[] teamMemberIds = new String[project.getTeamMembers().length];
            for (int i = 0; i < project.getTeamMembers().length; i++) {
                teamMemberIds[i] = project.getTeamMembers()[i].getId().toHexString();
            }
            dto.setTeamMemberIds(teamMemberIds);
        }

        return dto;
    }

    public Project toEntity(ProjectDTO dto) {
        Project project = new Project();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            project.setId(new ObjectId(dto.getId()));
        }

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setBudget(dto.getBudget());

        if (dto.getTeamMemberIds() != null) {
            Employee[] teamMembers = new Employee[dto.getTeamMemberIds().length];
            for (int i = 0; i < dto.getTeamMemberIds().length; i++) {
                String id = dto.getTeamMemberIds()[i];
                teamMembers[i] = employeeService.getEmployeeById(new ObjectId(dto.getTeamMemberIds()[i]))
                        .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
            }
            project.setTeamMembers(teamMembers);
        }

        return project;
    }

}
