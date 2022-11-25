package com.example.moonbaseresearchmanagement.earthmanager;

import com.example.moonbaseresearchmanagement.groundstation.GroundStation;
import com.example.moonbaseresearchmanagement.personnel.Personnel;

import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    
    @ManyToOne
    @JoinColumn(name = "station_name")
    private GroundStation station_name;

    public EarthManager(int personnel_id, String name, String country, GroundStation station_name) {
        super(personnel_id, name, country);
        this.station_name = station_name;
    }
    
    public GroundStation getStation_name() {
        return station_name;
    }

    public void setStation_name(GroundStation station_name) {
        this.station_name = station_name;
    }

  

    
}
