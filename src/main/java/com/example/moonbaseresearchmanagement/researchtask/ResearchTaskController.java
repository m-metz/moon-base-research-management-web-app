package com.example.moonbaseresearchmanagement.researchtask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/researchtask" )
public class ResearchTaskController {
    private final ResearchTaskService researchTaskService;

    @Autowired
    public ResearchTaskController(ResearchTaskService researchTaskService) {
        this.researchTaskService = researchTaskService;
    }

    @GetMapping
    public List<ResearchTask> getMoonManagers() {
        return researchTaskService.getAllResearchTasks();
    }
    
}
