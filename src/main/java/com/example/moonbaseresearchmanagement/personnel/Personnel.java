package com.example.moonbaseresearchmanagement.personnel;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id")
    private int personnel_id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    

    
    
    
    public int getPersonnel_id() {
        return personnel_id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setPersonnel_id(int personnel_id) {
        this.personnel_id = personnel_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    


    
}
