package com.employee.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.DTO.ApiResponse;
import com.employee.employee.DTO.ProjectDTO;
import com.employee.employee.Service.ProjectService;
import com.employee.employee.models.Project;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{name}")
    public ResponseEntity<ApiResponse<ProjectDTO>> getByName(String name) {
        return projectService.getByName(name)
                .map(project -> ResponseEntity.ok(new ApiResponse<>("Project found", projectService.toDTO(project)))).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Project not found")));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody Project project, String[] employeeId){
        String message = projectService.createProject(project,employeeId);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProject(@RequestBody ProjectDTO project){
        String message = projectService.updateProject(project);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/assign")
    public ResponseEntity<String> assignEmployee(@RequestBody String[] employeeId, String projectId,String roleId){
        String message = projectService.assignProject(employeeId, projectId, roleId);
        return ResponseEntity.ok(message);
    }
}
