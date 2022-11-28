package com.example.moonbaseresearchmanagement.rocket;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketRepository extends JpaRepository<Rocket, Integer> {
    Optional<Rocket> findRocketByName(String name);
}
