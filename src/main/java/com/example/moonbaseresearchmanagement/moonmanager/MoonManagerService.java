package com.example.moonbaseresearchmanagement.moonmanager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoonManagerService {
    
    private final MoonManagerRepository moonManagerRepository;

    @Autowired
    public MoonManagerService(MoonManagerRepository moonManagerRepository) {
        this.moonManagerRepository = moonManagerRepository;
    }

    public List<MoonManager> getAllMoonManagers() {
        return moonManagerRepository.findAll();
    }

    public Optional<MoonManager> getMoonManagerById(int id) {
        return moonManagerRepository.findById(id);
    }
    
}
