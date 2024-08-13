package com.employee.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.DTO.ApiResponse;
import com.employee.employee.Service.ProjectService;
import com.employee.employee.models.Project;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{name}")
    public ResponseEntity<ApiResponse<Project>> getByName(String name) {
        return projectService.getByName(name)
                .map(project -> ResponseEntity.ok(new ApiResponse<>("Project found", project))).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Project not found")));
    }
}
