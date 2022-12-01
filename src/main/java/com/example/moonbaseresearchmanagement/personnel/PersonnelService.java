package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.moonbaseresearchmanagement.earthmanager.EarthManager;
import com.example.moonbaseresearchmanagement.earthmanager.EarthManagerService;
import com.example.moonbaseresearchmanagement.moonmanager.MoonManager;
import com.example.moonbaseresearchmanagement.moonmanager.MoonManagerService;
import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcher;
import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcherService;
import com.example.moonbaseresearchmanagement.project.*;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final ProjectService projectService;
    private final MoonManagerService moonManagerService;
    private final MoonResearcherService moonResearcherService;
    private final EarthManagerService earthManagerService;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository, ProjectService projectService, MoonManagerService moonManagerService, MoonResearcherService moonResearcherService, EarthManagerService earthManagerService ) {
        this.personnelRepository = personnelRepository;
        this.projectService = projectService;
        this.moonManagerService = moonManagerService;
        this.moonResearcherService = moonResearcherService;
        this.earthManagerService = earthManagerService; 
    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public List<Personnel> getPersonnelSorted() {
        return personnelRepository.findByOrderByNameAsc();
    }
    
    public void addToProject(int id, int project_id) { 
       Project project = projectService.getProject(project_id);
       Optional<Personnel> searchPersonnel = personnelRepository.findByPersonnelId(id);
       if (searchPersonnel.isPresent()){
            Personnel personnel = searchPersonnel.get();
            //Checking for new project
            if(personnel.checkProject(project) == true){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel already registered in this project id!");
            }
            else{
                //Checking for max number of projects
                if (personnel.numProjects() < 4){
                    personnel.addProject(project);
                    personnelRepository.save(personnel);
                }   
                else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel already registered in 4 projects!");
                }
            }  
        }
        else{
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel not found!");
       }  
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

    public Personnel addNewPersonnel(Personnel personnel) {
        //Check if same Personnel already Registered (Name and Country Must Match)
        Optional<Personnel> searchPersonnel = personnelRepository.findByName(personnel.getName());
        if (searchPersonnel.isPresent()){
            Personnel foundPersonnel = searchPersonnel.get();
            if (personnel.compareCountry(foundPersonnel.getCountry()) == true){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel already registered in the database");
            }
            else{
                personnel = personnelRepository.save(personnel);
            }
        }
        else{
            personnel = personnelRepository.save(personnel);
        }
        return personnel;
    }

    public String getTitle(int id) {
        //Check if id is of moon researcher
        Optional<MoonResearcher> searchResearcher = moonResearcherService.getMoonResearcherById(id);
        if(searchResearcher.isPresent()){
            Optional<MoonManager> searchMoonManager = moonManagerService.getMoonManagerById(id);
            if (searchMoonManager.isPresent()){
                return "Moon Manager";
            }
            else{
                return "Moon Researcher";
            }

        }
        else{
            Optional<EarthManager> searchEarthManager = earthManagerService.getEarthManagerById(id);
            if(searchEarthManager.isPresent()){
                return "Earth Manager";
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel id  not Foud");
            }
        }

    }

   
    
}
