package com.example.moonbaseresearchmanagement.groundstation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroundStationService {

    private final GroundStationRepository groundStationRepository;

    @Autowired
    public GroundStationService(GroundStationRepository groundStationRepository) {
        this.groundStationRepository = groundStationRepository;
    }

    public List<GroundStation> getAllGroundStations() {
        return groundStationRepository.findAll();
    }
    
}
