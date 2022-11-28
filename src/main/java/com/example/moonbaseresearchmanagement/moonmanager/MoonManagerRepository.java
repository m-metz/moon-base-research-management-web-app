package com.example.moonbaseresearchmanagement.moonmanager;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoonManagerRepository extends JpaRepository<MoonManager, Integer> {

    
    
}
