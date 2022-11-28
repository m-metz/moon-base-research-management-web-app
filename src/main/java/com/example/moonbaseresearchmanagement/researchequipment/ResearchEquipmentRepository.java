package com.example.moonbaseresearchmanagement.researchequipment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchEquipmentRepository extends JpaRepository<ResearchEquipment, Integer> {
    
}
