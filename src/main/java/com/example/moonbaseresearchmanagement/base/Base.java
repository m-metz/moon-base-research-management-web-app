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
    private int baseId;

    private String name;

    private String location;

    @OneToMany(mappedBy = "base")
    private List<MoonResearcher> baseMoonResearchers;

    @OneToMany(mappedBy = "base")
    private List<Building> baseBuildings;

    @OneToMany(mappedBy = "base")
    private List<ResearchEquipment> baseEquipments;


}
