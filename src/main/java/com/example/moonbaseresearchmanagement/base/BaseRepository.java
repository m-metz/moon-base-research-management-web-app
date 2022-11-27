package com.example.moonbaseresearchmanagement.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseRepository extends JpaRepository<Base, Long>{
    
    Optional<Base> findByName(String name);
}
