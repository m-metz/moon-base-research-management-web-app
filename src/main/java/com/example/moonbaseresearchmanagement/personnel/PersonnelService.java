package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.moonbaseresearchmanagement.project.*;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final ProjectService projectService;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository, ProjectService projectService) {
        this.personnelRepository = personnelRepository;
        this.projectService = projectService;

    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public List<Personnel> getPersonnelSorted() {
        return personnelRepository.findByOrderByNameAsc();
    }
    
    public void addToProject(int id, int project_id) {

       Project project = projectService.getProject(project_id);
       Personnel personnel = personnelRepository.findByPersonnelId(id).get();

       personnel.getListProjects().add(project);
        
       personnelRepository.save(personnel);

    }

   
    
}
