package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoonResearcherService {

    private final MoonResearcherRepository moonResearcherRepository;

    @Autowired
    public MoonResearcherService(MoonResearcherRepository moonResearcherRepository) {
        this.moonResearcherRepository = moonResearcherRepository;
    }

    public List<MoonResearcher> getAllMoonResearchers() {
        return moonResearcherRepository.findAll();
    }
    
}