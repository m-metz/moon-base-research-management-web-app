package com.example.moonbaseresearchmanagement.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(int project_id) {
        Optional<Project> searchProject = projectRepository.findByProjectId(project_id);
        if (searchProject.isPresent()){
            return projectRepository.findByProjectId(project_id).get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found!");
        }
    }

    public Project getProjectByName(String name) {
        Optional<Project> searchProject = projectRepository.findByName(name);
        if (searchProject.isPresent()){
            return searchProject.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project "+ name+ " not found");
        }
    }
    
}
