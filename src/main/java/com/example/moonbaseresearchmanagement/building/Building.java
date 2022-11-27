package com.example.moonbaseresearchmanagement.building;


import com.example.moonbaseresearchmanagement.base.Base;

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
    
}
