package com.example.moonbaseresearchmanagement.groundstation;

import java.util.List;

import com.example.moonbaseresearchmanagement.earthmanager.EarthManager;

import jakarta.persistence.*;

@Entity
@Table(name = "ground_station")
public class GroundStation {
    @Id
    private String name;

    private String country;

    @OneToMany(mappedBy = "groundStation")
    private List<EarthManager> listEarthManagers;
}
