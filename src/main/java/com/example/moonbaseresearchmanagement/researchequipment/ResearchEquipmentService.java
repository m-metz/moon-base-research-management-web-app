package com.example.moonbaseresearchmanagement.researchequipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchEquipmentService {
    private final ResearchEquipmentRepository researchEquipmentRepository;

    @Autowired
    public ResearchEquipmentService(ResearchEquipmentRepository researchEquipmentRepository) {
        this.researchEquipmentRepository = researchEquipmentRepository;
    }

    public List<ResearchEquipment> getAllResearchEquipments() {
        return researchEquipmentRepository.findAll();
    }
    
}
