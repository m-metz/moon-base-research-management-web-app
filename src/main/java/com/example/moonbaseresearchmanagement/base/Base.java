package com.example.moonbaseresearchmanagement.base;
import java.util.List;

import com.example.moonbaseresearchmanagement.building.Building;
import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcher;
import com.example.moonbaseresearchmanagement.researchequipment.ResearchEquipment;

import jakarta.persistence.*;

@Entity
@Table(name = "base")
public class Base {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_id")
    private Long baseId;

    private String name;

    private String location;

    @OneToMany(mappedBy = "base")
    private List<MoonResearcher> baseMoonResearchers;

    @OneToMany(mappedBy = "base")
    private List<Building> baseBuildings;

    @OneToMany(mappedBy = "base")
    private List<ResearchEquipment> baseEquipments;

    public Long getBaseID(){
        return baseId;
    }

    public Base setBaseID(Long id){
        this.baseId = id;
        return this;
    }

    public String getName(){
        return name;    
    }

    public Base setName(String name){
        this.name = name;
        return this;
    }

    public String getLocation(){
        return location;
    }

    public Base setLocation(String location){
        this.location = location;
        return this;
    }


}
