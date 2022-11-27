package com.example.moonbaseresearchmanagement.earthmanager;

import com.example.moonbaseresearchmanagement.groundstation.GroundStation;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    @ManyToOne
    @JoinColumn(name = "station_name")
    private GroundStation groundStation;

    public EarthManager(int personnelId, String name, String country, GroundStation stationName) {
        super(personnelId, name, country);
        this.groundStation = stationName;
    }

    public GroundStation getGroundStation() {
        return groundStation;
    }

    public void setGroundStation(GroundStation station_name) {
        this.groundStation = station_name;
    }
}
