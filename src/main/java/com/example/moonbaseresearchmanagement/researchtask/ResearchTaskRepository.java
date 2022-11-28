package com.example.moonbaseresearchmanagement.researchtask;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchTaskRepository extends JpaRepository<ResearchTask, Integer> {
    Optional<ResearchTask> findResearchTaskByName(String name);
}
