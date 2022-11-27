package com.example.moonbaseresearchmanagement.building;


import java.util.List;

import com.example.moonbaseresearchmanagement.base.Base;
import com.example.moonbaseresearchmanagement.project.Project;

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

    @OneToMany(mappedBy = "building")
    private List<Project> buildingProjects;
    
}
