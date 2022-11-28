package com.example.moonbaseresearchmanagement.building;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingRepository extends JpaRepository<Building, Integer> {
    
    Optional<Building> findBuildingByBuildingId(int buildingid);


    
}
