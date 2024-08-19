package com.employee.employee.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employee.employee.Controller.RoleController;
import com.employee.employee.models.Role;
import com.employee.employee.repository.RoleRepository;

@Service
public class RoleService {

    public static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> getById(ObjectId id){
        return roleRepository.findById(id);
    }

    public Optional<Role> getByTitle(String title){
        return roleRepository.findByTitle(title);
    }

    public String createRole(Role role) throws DataAccessException{
        try{
            roleRepository.save(role);
            return "Role created successfully";
        }
        catch(DataAccessException e){
            throw new RuntimeException("Failed to create role: "+e.getMessage(),e);
        }
    }
}
