package com.example.moonbaseresearchmanagement.earthmanager;

import com.example.moonbaseresearchmanagement.personnel.Personnel;

import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    
    
    @ManyToOne
    @JoinColumn(name = "station_name")
    private GroundBase base;
}
