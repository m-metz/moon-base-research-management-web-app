package com.example.moonbaseresearchmanagement.building;


import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.base.Base;
import com.example.moonbaseresearchmanagement.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private int buildingId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "base_id")
    private Base base;

    @JsonIgnore
    @OneToMany(mappedBy = "building")
    private List<Project> buildingProjects = new ArrayList<>();
    
    public Building(){}

    

    public Building(int buildingId, String name, Base base) {
        this.buildingId = buildingId;
        this.name = name;
        this.base = base;
    }

    
    public Building(String name, Base base) {
        this.name = name;
        this.base = base;
    }


    public Building(int buildingId, String name, Base base, List<Project> buildingProjects) {
        this.buildingId = buildingId;
        this.name = name;
        this.base = base;
        this.buildingProjects = buildingProjects;
    }


    public Building(String name, Base base, List<Project> buildingProjects) {
        this.name = name;
        this.base = base;
        this.buildingProjects = buildingProjects;
    }



    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public List<Project> getBuildingProjects() {
        return buildingProjects;
    }

    public void setBuildingProjects(List<Project> buildingProjects) {
        this.buildingProjects = buildingProjects;
    }
}
 
