package com.example.moonbaseresearchmanagement.personnel;

import java.util.Set;
import com.example.moonbaseresearchmanagement.project.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id")
    private int personnel_id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @ManyToMany
    @JoinTable(
        name = "works_on", 
        joinColumns = @JoinColumn(name = "personnel_id"), 
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    Set<Project> listProjects;

    public Personnel() {}

    public Personnel(int personnel_id, String name, String country) {
        this.personnel_id = personnel_id;
        this.name = name;
        this.country = country;
    }

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
