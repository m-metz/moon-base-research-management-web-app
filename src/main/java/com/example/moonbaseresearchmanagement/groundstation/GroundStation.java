package com.example.moonbaseresearchmanagement.groundstation;

import java.util.ArrayList;
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
    private List<EarthManager> listEarthManagers = new ArrayList<>();

    public GroundStation(){}

    public GroundStation(String name, String country) {
        this.name = name;
        this.country = country;
    }


    public GroundStation(String name, String country, List<EarthManager> listEarthManagers) {
        this.name = name;
        this.country = country;
        this.listEarthManagers = listEarthManagers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<EarthManager> getListEarthManagers() {
        return listEarthManagers;
    }

    public void setListEarthManagers(List<EarthManager> listEarthManagers) {
        this.listEarthManagers = listEarthManagers;
    }

    
}
