package com.example.moonbaseresearchmanagement.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends JpaRepository<Base, Integer> {
    Optional<Base> findByName(String name);
    Optional<Base> findBaseByBaseId(int baseId);

}
