package com.employee.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.DTO.ApiResponse;
import com.employee.employee.Service.RoleService;
import com.employee.employee.models.Role;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
    

    @Autowired
    private RoleService roleService;

    @GetMapping("/{name}")
    public ResponseEntity<ApiResponse<Role>> getByTitle(String name) {
        return roleService.getByTitle(name)
                .map(role -> ResponseEntity.ok(new ApiResponse<>("Role found", role)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Role not found")));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRole(@RequestBody Role role){  
        String message = roleService.createRole(role);
        return ResponseEntity.ok(message);
    }
}
