package com.example.moonbaseresearchmanagement.transport;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {
    Optional<Transport> findTransportByName(String name);
}
