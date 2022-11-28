package com.example.moonbaseresearchmanagement.researchequipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/researchequipment" )
public class ResearchEquipmentController {
    private final ResearchEquipmentService researchEquipmentService;

    @Autowired
    public ResearchEquipmentController(ResearchEquipmentService researchEquipmentService) {
        this.researchEquipmentService = researchEquipmentService;
    }

    @GetMapping
    public List<ResearchEquipment> getResearchEquipments() {
        return researchEquipmentService.getAllResearchEquipments();
    }
    
}
