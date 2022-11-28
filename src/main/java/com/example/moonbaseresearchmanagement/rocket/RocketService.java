package com.example.moonbaseresearchmanagement.rocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RocketService {

    private final RocketRepository rocketRepository;

    @Autowired
    public RocketService(RocketRepository rocketRepository) {
        this.rocketRepository = rocketRepository;
    }

    public List<Rocket> getAllRockets() {
        return rocketRepository.findAll();
    }
    
    
}
