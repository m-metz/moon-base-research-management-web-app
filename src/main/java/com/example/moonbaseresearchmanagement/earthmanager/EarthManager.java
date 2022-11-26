package com.example.moonbaseresearchmanagement.earthmanager;

import com.example.moonbaseresearchmanagement.groundstation.GroundStation;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    @ManyToOne
    @JoinColumn(name = "station_name")
    private GroundStation stationName;

    public EarthManager(int personnelId, String name, String country, GroundStation stationName) {
        super(personnelId, name, country);
        this.stationName = stationName;
    }

    public GroundStation getStation_name() {
        return stationName;
    }

    public void setStation_name(GroundStation station_name) {
        this.stationName = station_name;
    }
}
