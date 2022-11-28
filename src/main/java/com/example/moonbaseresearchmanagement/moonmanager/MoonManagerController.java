package com.example.moonbaseresearchmanagement.moonmanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/moonmanager" )
public class MoonManagerController {
    private final MoonManagerService moonManagerService;

    @Autowired
    public MoonManagerController(MoonManagerService moonManagerService) {
        this.moonManagerService = moonManagerService;
    }

    @GetMapping
    public List<MoonManager> getMoonManagers() {
        return moonManagerService.getAllMoonManagers();
    }
    
}
