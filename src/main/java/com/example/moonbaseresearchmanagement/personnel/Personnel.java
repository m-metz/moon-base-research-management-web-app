package com.example.moonbaseresearchmanagement.personnel;

import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Project> listProjects = new ArrayList<>();

    public Personnel() {}

    public Personnel(int personnelId, String name, String country) {
        this.personnelId = personnelId;
        this.name = name;
        this.country = country;
    }

    public Personnel(String name, String country) {
        this.name = name;
        this.country = country;
    }


    public Personnel(int personnelId, String name, String country, List<Project> listProjects) {
        this.personnelId = personnelId;
        this.name = name;
        this.country = country;
        this.listProjects = listProjects;
    }


    public Personnel(String name, String country, List<Project> listProjects) {
        this.name = name;
        this.country = country;
        this.listProjects = listProjects;
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

    public boolean compareCountry(String country2) {
        if (country.equals(country2) == true){
            return true;
        }

        return false;

    }

    public void addProject(Project project) {
        listProjects.add(project);
    }

    public void removeProject(Project project) {
        listProjects.remove(project);
    }

    public int numProjects() {

        return listProjects.size();
    }

    //Method to check if already registered in specifc project
    public boolean checkProject(Project project) {
        Project regProject = null;
        for(int i = 0; i < listProjects.size(); i ++){
            regProject = listProjects.get(i);
            if(regProject.getProjectId() == project.getProjectId()){
                return true;
            }
        }
        return false;
    }
}
