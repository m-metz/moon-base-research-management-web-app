package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "api/v1/personnel" )
public class PersonnelController {

    private final PersonnelService personnelService;

    @Autowired
    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
        }

    @GetMapping
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
        }

    @GetMapping("/sorted")
    public List<Personnel> getPersonnelSorted(){
        //TODO
        return null;
        }

    @GetMapping("/name={name}")
    public Personnel getPersonnel(@PathVariable String name){
        //TODO
        return null;
        }

    @PostMapping("/add")
        public Personnel addPersonnel(@RequestBody Personnel personnel){
            //TODO
            return null;
        }
    
    @PatchMapping("/update={id}")
        public Personnel updatePersonnel(@PathVariable int id, @RequestParam(required = false) String name, @RequestParam(required = false) String country){
            //TODO
            return null;
        }

    @DeleteMapping("delete={id}")
        public void deletePersonnel(@PathVariable int id){
            //TODO
        }
    

    @PostMapping("/addProject={project_id}")
        public void addProject(){
            //TODO
        }

    @DeleteMapping("/personnel={id}/removeProject={project_id}")
        public void removeProject(@PathVariable int id, @PathVariable int project_id){
            //TODO
        }



}

    
    

