package com.example.moonbaseresearchmanagement.earthmanager;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarthManagerRepository extends JpaRepository<EarthManager, Integer> {
    


}
