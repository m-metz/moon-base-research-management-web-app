package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import jakarta.transaction.Transactional;
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

    public void removeFromProject(int id, int project_id) { 
        Project project = projectService.getProject(project_id);
        Optional<Personnel> searchPersonnel = personnelRepository.findByPersonnelId(id);
        if (searchPersonnel.isPresent()){
             Personnel personnel = searchPersonnel.get();
             //Checking project is not already enrolled
             if(personnel.checkProject(project) == false){
                 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel is not registered to this project id!");
             }
             else{
                 
                personnel.removeProject(project);
                personnelRepository.save(personnel);
             }  
         }
         else{
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel not found!");
        }  
     }

     public void deletePersonnel(int id) {
        Optional<Personnel> searchPersonnel = personnelRepository.findByPersonnelId(id);
        if(searchPersonnel.isPresent()){
            Personnel personnel = searchPersonnel.get();
            //check wich type of professinal it is
            Optional<MoonResearcher> searchMoonResearcher = moonResearcherService.getMoonResearcherById(id);
           if (searchMoonResearcher.isPresent()){
                Optional<MoonManager> searchMoonManager = moonManagerService.getMoonManagerById(id);
                if(searchMoonManager.isPresent()){
                    MoonManager moonManager = searchMoonManager.get();
                    moonManager.removeAllManagedprojects();
                    moonManagerService.updateMoonManager(moonManager);           
                }
           }
           else{
                Optional<EarthManager> searchEarthManager = earthManagerService.getEarthManagerById(id);
                if(searchEarthManager.isPresent()){
                    EarthManager earthManager = searchEarthManager.get();
                    earthManager.removeAllManagedprojects();
                    earthManagerService.updateEarthManager(earthManager); 
                }

           }
           //Clear Many-to-Many
            personnel.removeAllprojects();
            personnelRepository.save(personnel);
            personnelRepository.delete(personnel);

        } 
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel with id "+id + " does not exist");
        }
        

    }

    public Personnel getPersonbyname(String name) {
        Optional<Personnel> searchPersonnel = personnelRepository.findByName(name);
        if (searchPersonnel.isPresent()){
            return searchPersonnel.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel "+ name+ " not found");
        }
    }

    public Personnel addNewPersonnel(Personnel personnel) {
        //Check if same Personnel already Registered (Name and Country Must Match)
        Optional<Personnel> searchPersonnel = personnelRepository.findByNameAndCountry(personnel.getName(), personnel.getCountry());
        if (searchPersonnel.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel already registered in the database");

        }
        else{
            personnel = personnelRepository.save(personnel);
        }
        return personnel;
    }
    


    public Personnel getPersonnelById(int id) {
        Optional<Personnel> searchPersonnel = personnelRepository.findById(id);
        if(searchPersonnel.isPresent()){
            return searchPersonnel.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel not found!");
    }

    public String getTitle(int id) {
        //Check if id is of moon researcher
        Optional<MoonResearcher> searchResearcher = moonResearcherService.getMoonResearcherById(id);
        if(searchResearcher.isPresent()){
            Optional<MoonManager> searchMoonManager = moonManagerService.getMoonManagerById(id);
            if (searchMoonManager.isPresent()){
                return "{\"title\":\"Moon Manager\"}";
            }
            else{
                return "{\"title\":\"Moon Researcher\"}";
            }

        }
        else{
            Optional<EarthManager> searchEarthManager = earthManagerService.getEarthManagerById(id);
            if(searchEarthManager.isPresent()){
                return "{\"title\":\"Earth Manager\"}";
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personel id  not Foud");
            }
        }
    }

    @Transactional
    public Personnel updatePersonnel(int id, String name, String country) {
        Personnel personnel = personnelRepository.findById(id).orElseThrow(()->
                                                                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel with Id: "+ id + " does not exist"));
                                     
        if (name!= null && name.length()>0 && !personnel.getName().equals(name)){
            personnel.setName(name);
        }

        if (country!= null && country.length()>0 && !personnel.getCountry().equals(country)){
            personnel.setCountry(country);
        }
        return personnel;

    }

    public List<Project> getProjects(int id) {
        Optional<Personnel> searchPersonnel = personnelRepository.findById(id);
        if (searchPersonnel.isPresent()){
            Personnel personnel = searchPersonnel.get();
            List<Project> projectList = personnel.getListProjects();
            if(projectList.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No projects assigned to Personnel id: " + id + "!"); 
            }
            return projectList;
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personnel not found"); 

        }
        
    }


    
}
