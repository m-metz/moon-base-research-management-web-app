package com.example.moonbaseresearchmanagement.base;

import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.building.Building;
import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcher;
import com.example.moonbaseresearchmanagement.researchequipment.ResearchEquipment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "base")
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_id")
    private int baseId;

    private String name;

    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "base")
    private List<MoonResearcher> baseMoonResearchers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "base")
    private List<Building> baseBuildings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "base")
    private List<ResearchEquipment> baseEquipments = new ArrayList<>();
    
    public Base (){}

    public Base(int baseId, String name, String location) {
        this.baseId = baseId;
        this.name = name;
        this.location = location;
    }


    public Base(String name, String location) {
        this.name = name;
        this.location = location;
    }

    

    public Base(String name, String location, List<MoonResearcher> baseMoonResearchers, List<Building> baseBuildings,
            List<ResearchEquipment> baseEquipments) {
        this.name = name;
        this.location = location;
        this.baseMoonResearchers = baseMoonResearchers;
        this.baseBuildings = baseBuildings;
        this.baseEquipments = baseEquipments;
    }

    public Base(int baseId, String name, String location, List<MoonResearcher> baseMoonResearchers,
            List<Building> baseBuildings, List<ResearchEquipment> baseEquipments) {
        this.baseId = baseId;
        this.name = name;
        this.location = location;
        this.baseMoonResearchers = baseMoonResearchers;
        this.baseBuildings = baseBuildings;
        this.baseEquipments = baseEquipments;
    }

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MoonResearcher> getBaseMoonResearchers() {
        return baseMoonResearchers;
    }

    public void setBaseMoonResearchers(List<MoonResearcher> baseMoonResearchers) {
        this.baseMoonResearchers = baseMoonResearchers;
    }

    public List<Building> getBaseBuildings() {
        return baseBuildings;
    }

    public void setBaseBuildings(List<Building> baseBuildings) {
        this.baseBuildings = baseBuildings;
    }

    public List<ResearchEquipment> getBaseEquipments() {
        return baseEquipments;
    }

    public void setBaseEquipments(List<ResearchEquipment> baseEquipments) {
        this.baseEquipments = baseEquipments;
    };


    public int getBaseID() {
        return baseId;
    }

    public Base setBaseID(int id) {
        this.baseId = id;
        return this;
    }

}
