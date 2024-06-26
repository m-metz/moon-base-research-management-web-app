package com.example.moonbaseresearchmanagement.earthmanager;

import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.groundstation.GroundStation;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "earth_manager")
public class EarthManager extends Personnel {
    @ManyToOne
    @JoinColumn(name = "station_name")
    private GroundStation groundStation;

    @JsonIgnore
    @OneToMany(mappedBy = "earthManager", orphanRemoval = true)
    private List<Project> managesProjects = new ArrayList<>();

    public EarthManager(){
        super();
    }

    public EarthManager(int personnelId, String name, String country, GroundStation stationName) {
        super(personnelId, name, country);
        this.groundStation = stationName;
    }


    public EarthManager(String name, String country, GroundStation groundStation) {
        super(name, country);
        this.groundStation = groundStation;
    }

    
    public EarthManager(int personnelId, String name, String country, GroundStation groundStation,
            List<Project> managesProjects) {
        super(personnelId, name, country);
        this.groundStation = groundStation;
        this.managesProjects = managesProjects;
    }

    public EarthManager(String name, String country, GroundStation groundStation, List<Project> managesProjects) {
        super(name, country);
        this.groundStation = groundStation;
        this.managesProjects = managesProjects;
    }

    

    public EarthManager(int personnelId, String name, String country, List<Project> listProjects,
            GroundStation groundStation) {
        super(personnelId, name, country, listProjects);
        this.groundStation = groundStation;
    }

    

    public EarthManager(String name, String country, List<Project> listProjects, GroundStation groundStation) {
        super(name, country, listProjects);
        this.groundStation = groundStation;
    }


    public EarthManager(int personnelId, String name, String country, List<Project> listProjects,
            GroundStation groundStation, List<Project> managesProjects) {
        super(personnelId, name, country, listProjects);
        this.groundStation = groundStation;
        this.managesProjects = managesProjects;
    }

    public EarthManager(String name, String country, List<Project> listProjects, GroundStation groundStation,
            List<Project> managesProjects) {
        super(name, country, listProjects);
        this.groundStation = groundStation;
        this.managesProjects = managesProjects;
    }

    public GroundStation getGroundStation() {
        return groundStation;
    }

    public void setGroundStation(GroundStation station_name) {
        this.groundStation = station_name;
    }

    public List<Project> getManagesProjects() {
        return managesProjects;
    }

    public void setManagesProjects(List<Project> managesProjects) {
        this.managesProjects = managesProjects;
    }

    public void addManagedProject(Project project) {
        managesProjects.add(project);
        project.setEarthManager(this);
    }

    public void removeManagedProject(Project project) {
        managesProjects.remove(project);
        project.setEarthManager(null);
    }

    public void removeAllManagedprojects(){
        Project project =null;
        int size = managesProjects.size();
        for (int i =0; i < size; i++){
            project = managesProjects.get(0);
            managesProjects.remove(project);
            project.setEarthManager(null);
        }
    }

    public int numManagedProjects() {

        return managesProjects.size();
    }

    public Project getManagedProject(int i) {
        return managesProjects.get(i);
    }




}
