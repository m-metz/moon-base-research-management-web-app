package com.example.moonbaseresearchmanagement.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends JpaRepository<Base, Long> {
    Optional<Base> findBaseByBaseId(int baseid);
}
