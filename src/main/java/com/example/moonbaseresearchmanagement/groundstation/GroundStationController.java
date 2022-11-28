package com.example.moonbaseresearchmanagement.groundstation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/groundstation")
public class GroundStationController {
    private final GroundStationService groundStationService;

    @Autowired
    public GroundStationController(GroundStationService groundStationService) {
        this.groundStationService = groundStationService;
    }

    @GetMapping
    public List<GroundStation> getGroundStations() {
        return groundStationService.getAllGroundStations();
    }
    
}
