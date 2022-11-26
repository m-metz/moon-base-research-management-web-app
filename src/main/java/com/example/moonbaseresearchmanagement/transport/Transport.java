package com.example.moonbaseresearchmanagement.transport;

import java.time.LocalDateTime;
import java.util.List;

import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcher;
import com.example.moonbaseresearchmanagement.rocket.Rocket;

import jakarta.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id")
    private int transportId;

    @ManyToOne
    @JoinColumn(name = "rocket_id")
    private Rocket rocketId;

    private String arrivalDeparture;

    private LocalDateTime time;

    private String fromTo; 
    
    @ManyToMany(mappedBy = "listTransports")
    List<MoonResearcher> listMoonReserachers;


}
