package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Personnel getPersonbyname(String name) {
        Optional<Personnel> searchPersonnel = personnelRepository.findByName(name);
        if (searchPersonnel.isPresent()){
            return searchPersonnel.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel "+ name+ " not Foud");
        }
    }

   
    
}
