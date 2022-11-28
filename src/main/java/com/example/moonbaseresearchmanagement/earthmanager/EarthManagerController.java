package com.example.moonbaseresearchmanagement.earthmanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/earthmanager")
public class EarthManagerController {

    private final EarthManagerService earthManagerService;

    @Autowired
    public EarthManagerController(EarthManagerService earthManagerService) {
        this.earthManagerService = earthManagerService;
    }

    @GetMapping
    public List<EarthManager> getEarthManagers() {
        return earthManagerService.getAllEarthManagers();
    }

    
}