package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/moonresearcher" )
public class MoonResearcherController {
    private final MoonResearcherService moonResearcherService;

    @Autowired
    public MoonResearcherController(MoonResearcherService moonResearcherService) {
        this.moonResearcherService = moonResearcherService;
    }

    @GetMapping
    public List<MoonResearcher> getMoonResearchers() {
        return moonResearcherService.getAllMoonResearchers();
    }
    
}
