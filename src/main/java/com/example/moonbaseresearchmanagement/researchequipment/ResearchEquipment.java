package com.example.moonbaseresearchmanagement.researchequipment;

import com.example.moonbaseresearchmanagement.base.Base;

import jakarta.persistence.*;

@Entity
@Table(name = "research_equipment")
public class ResearchEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equip_id")
    private int equipId;

    private String name;

    private boolean inUse;

    @ManyToOne
    @JoinColumn(name = "base_id")
    private Base base;
}
