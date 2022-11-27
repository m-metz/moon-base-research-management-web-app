package com.example.moonbaseresearchmanagement.earthmanager;

import java.util.List;

import com.example.moonbaseresearchmanagement.groundstation.GroundStation;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.project.Project;

import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    @ManyToOne
    @JoinColumn(name = "station_name")
    private GroundStation groundStation;

    @OneToMany(mappedBy = "earthManager")
    private List<Project> managesProjects;


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
