package com.example.moonbaseresearchmanagement.groundstation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundStationRepository extends JpaRepository<GroundStation, Integer> {
    Optional<GroundStation> findGroundStationByName(String name);
    
}
