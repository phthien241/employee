package com.employee.employee.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employee.employee.models.ProjectAssignment;
import com.employee.employee.repository.ProjectAssignmentRepository;

@Service
public class ProjectAssigmentService {
    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    public Optional<ProjectAssignment> getById(ObjectId id){
        return projectAssignmentRepository.findById(id);
    }
    
    public String createProjectAssignment(ProjectAssignment projectAssignment) throws DataAccessException{
        projectAssignmentRepository.save(projectAssignment);
        return "Assign project successfully";
    }
}
