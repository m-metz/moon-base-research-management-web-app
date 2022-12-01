package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.List;
import java.util.Optional;

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

    public Optional<MoonResearcher> getMoonResearcherById(int id) {
        return moonResearcherRepository.findById(id);
    }

    public void delete(MoonResearcher moonResearcher) {
        moonResearcherRepository.delete(moonResearcher);
    }
    
}
