package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoonResearcherRepository extends JpaRepository<MoonResearcher, Integer> {
    Optional<MoonResearcher> findMoonResearcherByName(String name);
    
}
