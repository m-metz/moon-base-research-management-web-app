package com.example.moonbaseresearchmanagement.earthmanager;

import com.example.moonbaseresearchmanagement.personnel.Personnel;

import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    
    @Column(name = "station_name")
    private String station_name;
    
    
}
