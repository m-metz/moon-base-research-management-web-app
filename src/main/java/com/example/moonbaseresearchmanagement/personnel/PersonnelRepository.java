package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    Optional<Personnel> findByPersonnelId(int personnel_id);

    List<Personnel> findByOrderByNameAsc();

    Optional<Personnel> findByName(String name);

    Optional<Personnel> findByNameAndCountry(String name, String country);
    
}
