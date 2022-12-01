package com.example.moonbaseresearchmanagement.earthmanager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarthManagerService {
    private final EarthManagerRepository earthManagerRepository;

    @Autowired
    public EarthManagerService(EarthManagerRepository earthManagerRepository) {
        this.earthManagerRepository = earthManagerRepository;
    }

    public List<EarthManager> getAllEarthManagers() {
        return earthManagerRepository.findAll();
    }

    public Optional<EarthManager> getEarthManagerById(int id) {
        return earthManagerRepository.findById(id);
    }

    

    
}
