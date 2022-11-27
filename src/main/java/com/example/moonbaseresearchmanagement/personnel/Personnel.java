package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;

import com.example.moonbaseresearchmanagement.project.Project;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id")
    private int personnelId;

    private String name;

    private String country;

    @ManyToMany
    @JoinTable(
        name = "works_on",
        joinColumns = @JoinColumn(name = "personnel_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> listProjects;

    public Personnel() {}

    public Personnel(int personnelId, String name, String country) {
        this.personnelId = personnelId;
        this.name = name;
        this.country = country;
    }

    public int getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(int personnelId) {
        this.personnelId = personnelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Project> getListProjects() {
        return listProjects;
    }

    public void setListProjects(List<Project> listProjects) {
        this.listProjects = listProjects;
    }
}
