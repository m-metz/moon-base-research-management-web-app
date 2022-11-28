package com.example.moonbaseresearchmanagement.researchtask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchTaskService {
    private final ResearchTaskRepository researchTaskRepository;

    @Autowired
    public ResearchTaskService(ResearchTaskRepository researchTaskRepository) {
        this.researchTaskRepository = researchTaskRepository;
    }

    public List<ResearchTask> getAllResearchTasks() {
        return researchTaskRepository.findAll();
    }
}
