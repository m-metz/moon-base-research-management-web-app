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


    public ResearchEquipment() {}

    

    public ResearchEquipment(int equipId, String name, boolean inUse, Base base) {
        this.equipId = equipId;
        this.name = name;
        this.inUse = inUse;
        this.base = base;
    }


    public ResearchEquipment(String name, boolean inUse, Base base) {
        this.name = name;
        this.inUse = inUse;
        this.base = base;
    }



    public int getEquipId() {
        return equipId;
    }

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

}